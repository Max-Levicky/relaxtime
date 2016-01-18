package relaxtime.api.controller;

import com.google.common.base.Strings;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import relaxtime.api.model.ApiResponse;
import relaxtime.api.model.ApiResponseStatus;
import relaxtime.api.model.ApiResponseStatus.ApiStatusCode;
import relaxtime.lib.model.RelaxStatus;
import relaxtime.lib.model.User;
import relaxtime.lib.service.TokenService;
import relaxtime.lib.service.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@RestController
@RequestMapping("/api/user")
public class UserController extends ApiController {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    private static Map<RelaxStatus, Set<RelaxStatus>> changeStatusMapping = new HashMap<>();
    static {
        changeStatusMapping.put(RelaxStatus.WORKING, Sets.newHashSet(RelaxStatus.PAUSED));
        changeStatusMapping.put(RelaxStatus.PAUSED, Sets.newHashSet(RelaxStatus.WORKING));
        changeStatusMapping.put(RelaxStatus.PENDING, Sets.newHashSet(RelaxStatus.ACCEPT, RelaxStatus.DECLINE));
    }

    @RequestMapping(value = "/info")
    public ApiResponse<User> getInfo(@RequestParam String token) {
        User user = null;
        if (!Strings.isNullOrEmpty(token)) {
            user = tokenService.getUserByToken(token);
        }
        if (user == null) {
            return wrapResponse(ApiResponseStatus.ApiStatusCode.UNAUTHORIZED, "User not found.");
        } else {
            return wrapResponse(user);
        }
    }

    @RequestMapping(value = "/startWork", method = RequestMethod.POST)
    public ApiResponse<User> startWork() {
        return changeRelaxStatus(RelaxStatus.WORKING);
    }

    @RequestMapping(value = "/stopWork", method = RequestMethod.POST)
    public ApiResponse<User> stopWork() {
        return changeRelaxStatus(RelaxStatus.PAUSED);
    }

    @RequestMapping(value = "/acceptRelax", method = RequestMethod.POST)
    public ApiResponse<User> acceptRelax() {
        return changeRelaxStatus(RelaxStatus.ACCEPT);
    }

    @RequestMapping(value = "/declineRelax", method = RequestMethod.POST)
    public ApiResponse<User> declineRelax() {
        return changeRelaxStatus(RelaxStatus.DECLINE);
    }

    private ApiResponse<User> changeRelaxStatus(RelaxStatus status) {
        User user = userService.getCurrentUser();
        if (!(changeStatusMapping.containsKey(user.getStatus())
                && changeStatusMapping.get(user.getStatus()).contains(status))) {
            return wrapResponse(ApiStatusCode.FORBIDDEN,
                    "Can't change status from " + user.getStatus() + " to " + status);
        }
        user.setStatus(status);
        userService.update(user);
        return wrapResponse(user);
    }

}
