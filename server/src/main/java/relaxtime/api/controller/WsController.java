package relaxtime.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * @author Max Levicky
 */
@Controller
public class WsController {
    private SimpMessagingTemplate template;

    @Autowired
    public WsController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping("/greeting")
    @SendTo("/topic/greetings")
    public String  handle(String greeting, Principal principal) {
        return "Yo: " + greeting;
    }

    @RequestMapping(value="/greetings")
    public void greet(String greeting) {
        String text = "Hi: " + greeting;
        this.template.convertAndSend("/topic/greetings", text);
    }
}
