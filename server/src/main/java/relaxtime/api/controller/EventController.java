package relaxtime.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
@RequestMapping("/event")
public class EventController extends ApiController {
    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    @RequestMapping
    @Secured("ROLE_USER")
    public List<Event> getEvents() {
        return eventService.getUserEvents(userService.getCurrentUser().getId());
    }

    @RequestMapping("/setStatus")
    public ApiResponse getEvent(@RequestParam("ids") long id) {
        return createOkResponse();
    }
}
