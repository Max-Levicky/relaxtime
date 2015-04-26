package relaxtime.controller;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import relaxtime.lib.model.*;
import relaxtime.lib.model.api.response.*;
import relaxtime.lib.service.TokenService;

import javax.ws.rs.CookieParam;

@RestController
public class EventController {
    @Autowired
    private TokenService tokenService;
    private ActivityType activityType = ActivityType.RELAX;
    private static Date lastEventTime = new Date();
    @RequestMapping("/")
    public String root() throws Exception {
        byte[] encoded = Files.readAllBytes(Paths.get("C:\\projects\\relaxtime\\gs-rest-service-master\\complete\\src\\main\\resources\\static\\examples\\hack.html"));
        return new String(encoded, "UTF-8");
    }

    @RequestMapping("/event")
    public List<? extends Event> greeting(@RequestParam String email,
                      @RequestParam(required = false) Long lastEvent) {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (lastEvent != null) {
            Date lastEventDate = new Date(lastEvent);
            if (!lastEventDate.before(lastEventTime)) {
                return new ArrayList<>();
            }
        }
        ActivityEvent activityEvent = new ActivityEvent();
        activityEvent.setLastModification(lastEventTime);
        Group group = new Group();
        User user = new User();
        User user2 = new User();
        User user3 = new User();
        Activity activity = new Activity();
        user.setEmail("vasia@pupkin.ru");
        user2.setEmail("pupkin@vasia.ru");
        user3.setEmail("omg@wft");
        activity.setType(activityType);
        switch (activityType) {
            case RELAX:
                activity.setName("Настольный теннис.");
                activity.setPlace("Комната отдыха #5.");
                group.setUsers(Lists.newArrayList(user));
                break;
            case AFTER_WORK:
                activity.setName("Предлагаем сходить куда-нибудь после работы с Вашими коллегами!");
                group.setUsers(Lists.newArrayList(user, user3));
                break;
            case LUNCH:
                activity.setName("Скоро обед!");
                activity.setPlace("Кофе-поинт.");
                group.setUsers(Lists.newArrayList(user, user2, user3));
        }
        group.setActivity(activity);
        activityEvent.setGroup(group);
        User user4 = new User();
        user4.setEmail(email);
        activityEvent.setTargetUser(user4);
        return Lists.newArrayList(
                activityEvent
        );
    }

    @RequestMapping("/event2")
    public List<? extends Event> greeting2(@CookieParam(value = "token") String token) {
        return null;
//        return tokenService.g
    }

    @RequestMapping(value = "/changeState", method = RequestMethod.POST)
    public ApiResponse changeState(@RequestParam(required = true) ActivityType state) {
        if (state == null) {
            return new Response(ResultCode.BAD_REQUEST, "Wrong state param");
        }
        lastEventTime = new Date();
        activityType = state;
        return new SuccessResponse();
    }
}
