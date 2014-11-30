package relaxtime.lib.model;

import java.util.HashMap;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
public class PlanedRelax extends Event {
    public Group group;
    public HashMap<Employee, EmployeeRelaxStatus> readyStatuses;
    public static enum EmployeeRelaxStatus { ACCEPT, DECLINE, UNKNOWN; }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public HashMap<Employee, EmployeeRelaxStatus> getReadyStatuses() {
        return readyStatuses;
    }

    public void setReadyStatuses(HashMap<Employee, EmployeeRelaxStatus> readyStatuses) {
        this.readyStatuses = readyStatuses;
    }
}
