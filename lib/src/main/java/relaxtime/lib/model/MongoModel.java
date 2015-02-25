package relaxtime.lib.model;

import javax.persistence.Id;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
public class MongoModel {
    @Id
    private long id;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
