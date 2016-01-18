package relaxtime.api.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author Max Levicky
 * @date 08.01.2016.
 */
@Aspect

public class BaseAspect {
    @Pointcut("within(relaxtime.api.controller..*)")
    public void controller() {}

    @Pointcut("args(relaxtime.lib.model.User)")
    public void userArg() {}
}
