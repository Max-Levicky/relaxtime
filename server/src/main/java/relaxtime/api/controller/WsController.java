package relaxtime.api.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @author Max Levicky
 */
@Controller
public class WsController {

    @MessageMapping("/ws")
    @SendTo("/topic/greetings")
    public String greeting(String name) throws Exception {
        Thread.sleep(3000); // simulated delay
        return "Hello,";
    }
}
