package relaxtime.core.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import relaxtime.lib.model.*;
import relaxtime.lib.service.ActivityService;
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
    private ActivityService activityService;
    private Random random = new Random();

    @Override
    public void step() {
        logger.debug("activity app step {}", ++step);
        List<User> mostUnrelaxed = userService.getMostUnrelaxed();
        List<User> group = new ArrayList<>();
        for (User user : mostUnrelaxed) {
            if (true) {
//            if (random.nextInt(mostUnrelaxed.size()) == 1) {
                group.add(user);
                if (group.size() > 1) {
                    break;
                }
            }
        }
        if (group.size() > 1) {
            logger.debug("Group formed");
            List<Activity> activities = activityService.getAvailableActivities(group);
            if (activities.size() < 1) {
                logger.debug("There is no available activity");
                return;
            }
            ActivityEvent event = new ActivityEvent();
            event.setGroup(new Group(group, activities.get(random.nextInt(activities.size()))));
            event.setTargetUser(group.get(0));
            eventService.saveEvent(event);
            event.setId(0);
            event.setTargetUser(group.get(1));
            eventService.saveEvent(event);
        }
    }
}
