package hello;

import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import relaxtime.lib.model.*;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public String root() throws Exception {
        byte[] encoded = Files.readAllBytes(Paths.get("C:\\Users\\maxds_000\\projects\\relaxtime\\gs-rest-service-master\\complete\\src\\main\\resources\\static\\examples\\hack.html"));
        return new String(encoded, "UTF-8");
    }

    @RequestMapping("/event")
    public List<? extends Event> greeting(@RequestParam String email) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ActivityEvent activityEvent = new ActivityEvent();
        Group group = new Group();
        User user = new User();
        user.setEmail("vasia@pupkin.ru");
        User user2 = new User();
        user2.setEmail("pupkin@vasia.ru");
        User user3 = new User();
        user3.setEmail("omg@wft");
        group.setUsers(Lists.newArrayList(user, user2, user3));
        Activity activity = new Activity();
        activity.setName("Настольный теннис.");
        activity.setPlace("Комната отдыха #5.");
        group.setActivity(activity);
        activityEvent.setGroup(group);
        User user4 = new User();
        user4.setEmail(email);
        activityEvent.setTargetUser(user4);
        return Lists.newArrayList(
                activityEvent
        );
    }

    @RequestMapping("/event2")
    public List<? extends Event> greeting2(@RequestParam String email) {
        return null;
    }
}
