package relaxtime.lib.model;

/**
 * @author Maxim
 */
public abstract class Event extends MongoModel {
    private User targetUser;

    public User getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(User targetUser) {
        this.targetUser = targetUser;
    }

}
