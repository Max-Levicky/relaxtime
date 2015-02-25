package relaxtime.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import relaxtime.api.dao.EventRepository;
import relaxtime.api.model.ApiResponse;
import relaxtime.lib.model.Event;

import java.util.List;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@Component
public class EventService extends BaseService {
    @Autowired
    private EventRepository eventRepository;

    public List<Event> getUserEvents(Long userId) {
        return eventRepository.getUserEvents(userId);
    }
}
