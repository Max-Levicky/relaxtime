package relaxtime.lib.model;


import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
//@Document(collection = "event")
@Entity
public class ActivityEvent extends Event {
    @Id
    private Long id;
    @ManyToOne
    private Group group;

    private Date lastModification;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Date getLastModification() {
        return lastModification;
    }

    public void setLastModification(Date lastModification) {
        this.lastModification = lastModification;
    }
}
