package relaxtime.lib.model;

import java.util.List;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
public class Group {
    private List<User> users;
    private Activity activity;

    public Group() {
    }

    public Group(List<User> users, Activity activity) {
        this.users = users;
        this.activity = activity;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
