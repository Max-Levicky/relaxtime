package relaxtime.lib.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
//@Document(collection = "department")
@Entity
public class Department extends BaseModel {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
