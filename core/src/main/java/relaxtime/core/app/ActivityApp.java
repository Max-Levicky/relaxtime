package relaxtime.core.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import relaxtime.lib.model.*;
import relaxtime.lib.service.EventService;
import relaxtime.lib.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@Component
public class ActivityApp extends App {
    private int step = 0;
    @Autowired
    private UserService userService;
    @Autowired
    private EventService eventService;
    @Autowired
    private ActivitySer
    private Random random = new Random();

    @Override
    public void step() {
        logger.debug("activity app step {}", ++step);
        List<User> mostUnrelaxed = userService.getMostUnrelaxed();
        List<User> pair = new ArrayList<>();
        for (User user : mostUnrelaxed) {
            if (random.nextInt(mostUnrelaxed.size()) == 1) {
                pair.add(user);
                if (pair.size() > 1) {
                    break;
                }
            }
        }
        if (pair.size() > 1) {
            ActivityEvent event = new ActivityEvent();
            event.setGroup(new Group(pair, ));
            eventService.saveEvent(event);
        }
    }
}
