package relaxtime.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import relaxtime.model.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maxim
 */
@RestController
@RequestMapping("/api/event")
public class EventController {
    @RequestMapping(method = RequestMethod.GET)
    private List<Event> getEvents() {
        return new ArrayList<Event>();
    }
}
