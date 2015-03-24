package relaxtime.lib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import relaxtime.lib.dao.ActivityRepository;
import relaxtime.lib.model.Activity;
import relaxtime.lib.model.Event;
import relaxtime.lib.model.User;

import java.util.List;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@Component
public class ActivityService extends BaseService<Activity> {
    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> getAvailableActivities(List<User> users) {
        return activityRepository.getAvailableActivities(users);
    }
}
