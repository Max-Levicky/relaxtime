package relaxtime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import relaxtime.lib.model.api.response.AuthResponse;
import relaxtime.lib.model.api.response.FailedAuthResponse;
import relaxtime.lib.model.api.response.SuccessAuthResponse;
import relaxtime.lib.service.TokenService;
import relaxtime.lib.service.UserService;

/**
 * @author Max Levicky
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserService userService;
    @RequestMapping(method = RequestMethod.POST)
    public AuthResponse auth(@RequestParam String login, @RequestParam String password) {
        if (userService.checkAuth(login, password)) {
            return new SuccessAuthResponse(tokenService.getNewToken(userService.getByName(login)));
        } else {
            return new FailedAuthResponse("Пользователь не найден");
        }
    }
}
