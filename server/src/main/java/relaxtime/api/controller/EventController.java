package relaxtime.api.controller;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import relaxtime.api.model.ApiResponse;
import relaxtime.lib.service.UserService;
import relaxtime.lib.model.Event;
import relaxtime.lib.service.EventService;

import java.util.List;

/**
 * @author Maxim
 */
@RestController
@RequestMapping("/api/event")
public class EventController extends ApiController {
    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    @RequestMapping
    public List<Event> getEvents() {
        return eventService.getUserEvents(userService.getCurrentUser().getId());
    }

    @RequestMapping("/setStatus")
    public ApiResponse getEvent(@RequestParam("ids") long id) {
        return createOkResponse();
    }

}
