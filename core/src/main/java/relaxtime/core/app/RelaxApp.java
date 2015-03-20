package relaxtime.core.app;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
public class RelaxApp extends App {
    private static Logger LOGGER = LoggerFactory.getLogger(RelaxApp.class);
    private boolean run = true;
    private Map<Class, Thread> runningApps = new HashMap<>();
    private List<Runnable> availableApps = Lists.newArrayList(context.getBean(ActivityApp.class));
    private volatile ConcurrentMap<Class, Date> appsActivities = new ConcurrentHashMap<>();
    private static final ApplicationContext context = new ClassPathXmlApplicationContext(
            "classpath:relaxtime/spring/main-context.xml",
            "classpath:relaxtime/spring/relax-app-context.xml",
            "classpath:relaxtime/spring/mongo-context.xml"
    );

    @Override
    public void step() {
        getApps().stream().filter(app -> !runningApps.containsKey(app.getClass())).forEach(app -> {
            Thread thread = new Thread(app);
            thread.start();
            logger.debug("New app started: {}", app.getClass().getName());
            runningApps.put(app.getClass(), thread);
        });
    }
//
//    @Override
//    public void run() {
////        new Thread(() -> {
////            try {
////                while (run) {
////                    Calendar cal = Calendar.getInstance();
////                    cal.setTime(new Date());
////                    cal.add(Calendar.SECOND, 10);
//////                    cal.add(Calendar.MINUTE, 10);
////                    Date date = cal.getTime();
////                    runningApps.forEach((appClass, app) -> {
////                        Date lastActivity = appsActivities.get(appClass);
////                        if (lastActivity == null || lastActivity.after(date)) {
////                            LOGGER.error("App {} has been stopped", app.getClass().getName());
////                            app.interrupt();
////                            runningApps.remove(appClass);
////                            appsActivities.remove(appClass);
////                        }
////                    });
////                    Thread.sleep(10000);
////                }
////            } catch (InterruptedException ignored) {}
////        });
//        while (run) {
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ignored) {}
//        }
//    }

    public void stop() {
        run = false;
    }

    public List<Runnable> getApps() {
        return availableApps;
    }

    public static void main(String[] args) {
        new Thread(new RelaxApp()).start();
    }
}
