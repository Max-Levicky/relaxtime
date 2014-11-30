package relaxtime.lib.model;

import java.util.List;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
public class Group {
    private List<Employee> employees;
    private RelaxMethod relaxMethod;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public RelaxMethod getRelaxMethod() {
        return relaxMethod;
    }

    public void setRelaxMethod(RelaxMethod relaxMethod) {
        this.relaxMethod = relaxMethod;
    }
}
