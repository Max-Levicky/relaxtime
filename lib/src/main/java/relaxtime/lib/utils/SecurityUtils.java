package relaxtime.lib.utils;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * @author Max Levicky
 */
public class SecurityUtils {
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String nextSessionId() {
        return new BigInteger(130, RANDOM).toString(32);
    }
}
