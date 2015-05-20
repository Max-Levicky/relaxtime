package relaxtime.api.controller;

import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import relaxtime.api.model.ApiResponse;
import relaxtime.api.model.ApiResponseStatus;
import relaxtime.lib.model.User;
import relaxtime.lib.service.TokenService;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@RestController
@RequestMapping("/api/user")
public class UserController extends ApiController {
    @Autowired
    private TokenService tokenService;

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
}
