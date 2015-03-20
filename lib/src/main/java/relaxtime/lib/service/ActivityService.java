package relaxtime.lib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import relaxtime.lib.dao.EventRepository;
import relaxtime.lib.model.Event;

import java.util.List;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@Component
public class ActivityService extends BaseService<Event> {
    @Autowired
    private ActivityRepository activityRepository;

}
