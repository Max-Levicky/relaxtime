package relaxtime.lib.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.List;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@Entity
public class Group {
    @Id
    private Long id;
    @ManyToMany
    private List<User> users;
    @OneToOne
    private Activity activity;

    public Group() {
    }

    public Group(List<User> users, Activity activity) {
        this.users = users;
        this.activity = activity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
