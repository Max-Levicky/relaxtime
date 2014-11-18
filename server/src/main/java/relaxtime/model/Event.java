package relaxtime.model;

/**
 * @author Maxim
 */
public abstract class Event {
    private int id;
    private Employee targetEmployee;

    public Employee getTargetEmployee() {
        return targetEmployee;
    }

    public void setTargetEmployee(Employee targetEmployee) {
        this.targetEmployee = targetEmployee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
