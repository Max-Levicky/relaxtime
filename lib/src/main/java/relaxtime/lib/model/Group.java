package relaxtime.lib.model;

import java.util.List;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
public class Group {
    private List<User> users;
    private RelaxMethod relaxMethod;

    public Group() {
    }

    public Group(List<User> users, RelaxMethod relaxMethod) {
        this.users = users;
        this.relaxMethod = relaxMethod;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public RelaxMethod getRelaxMethod() {
        return relaxMethod;
    }

    public void setRelaxMethod(RelaxMethod relaxMethod) {
        this.relaxMethod = relaxMethod;
    }
}
