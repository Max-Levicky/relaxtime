package relaxtime.lib.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@Document(collection = "event")
public class ActivityEvent extends Event {
    private Group group;
    private HashMap<User, EmployeeRelaxStatus> readyStatuses;
    public static enum EmployeeRelaxStatus { ACCEPT, DECLINE, UNKNOWN; }

    @Override
    @Id
    public long getId() {
        return super.getId();
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public HashMap<User, EmployeeRelaxStatus> getReadyStatuses() {
        return readyStatuses;
    }

    public void setReadyStatuses(HashMap<User, EmployeeRelaxStatus> readyStatuses) {
        this.readyStatuses = readyStatuses;
    }
}
