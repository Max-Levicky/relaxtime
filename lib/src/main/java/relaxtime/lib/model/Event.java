package relaxtime.lib.model;

import javax.persistence.ManyToOne;

/**
 * @author Maxim
 */
public abstract class Event extends BaseModel {
    abstract public User getTargetUser();
    abstract public void setTargetUser(User targetUser);
}
