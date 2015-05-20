package relaxtime.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import relaxtime.api.model.ApiResponse;
import relaxtime.api.model.ApiResponseStatus.ApiStatusCode;
import relaxtime.lib.model.api.Token;
import relaxtime.lib.service.TokenService;
import relaxtime.lib.service.UserService;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@RestController
@RequestMapping("/auth")
public class AuthController extends ApiController {
    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;


    @RequestMapping
    public ApiResponse<String> auth(@RequestParam String login, @RequestParam String pass, HttpServletResponse response) {
        if (userService.checkAuth(login, pass)) {
            Token token = tokenService.getNewToken(userService.getByName(login));
            return wrapResponse(token.getToken());
        } else {
            return wrapResponse(ApiStatusCode.UNAUTHORIZED, "Bad credentials.");
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ApiResponse removeToken(@RequestParam String token) {
        tokenService.deleteToken(token);
        return createOkResponse();
    }
}
