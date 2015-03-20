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
public class EventService extends BaseService<Event> {
    @Autowired
    private EventRepository eventRepository;

    public List<Event> getUserEvents(Long userId) {
        return eventRepository.getUserEvents(userId);
    }

    public void saveEvent(Event event) {
        eventRepository.save(event);
    }
}
