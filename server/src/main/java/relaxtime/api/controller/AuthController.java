package relaxtime.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import relaxtime.api.model.ApiResponse;
import relaxtime.api.model.ApiResponseStatus.ApiStatusCode;
import relaxtime.api.security.AuthService;
import relaxtime.lib.service.TokenService;
import relaxtime.lib.service.UserService;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@RestController
@RequestMapping("/auth")
public class AuthController extends ApiController {
    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;


    @RequestMapping
    public ApiResponse<String> auth(@RequestParam String login, @RequestParam String pass) {
        if (userService.checkAuth(login, pass)) {
            relaxtime.lib.model.api.Token token = tokenService.getNewToken(userService.getByName(login));
            return wrapResponse(token.getToken());
        } else {
            return wrapResponse(ApiStatusCode.UNAUTHORIZED, "You are not authorized.");
        }
    }
}
