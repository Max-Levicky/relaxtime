package relaxtime.core.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
abstract public class App implements Runnable {
    protected boolean run = true;
    protected long delay = 10000;
    protected Logger logger;

    public App() {
        logger = LoggerFactory.getLogger(this.getClass());
    }

    public abstract void step();

    @Override
    public void run() {
        while (run) {
            step();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                processInterruptedException(e);
            }
        }
    }

    public void stop() {
        run = false;
    }

    protected void processInterruptedException(InterruptedException e) {
        logger.error("InterruptedException has happened", e);
        stop();
    }
}
