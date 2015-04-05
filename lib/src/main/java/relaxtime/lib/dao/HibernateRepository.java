package relaxtime.lib.dao;

import org.hibernate.Session;
import relaxtime.lib.model.BaseModel;

import java.io.Serializable;

/**
 * @author Max Levicky
 */
public abstract class HibernateRepository<T extends Serializable> {
    public abstract Session getSession();
    public void save(T model) {
        getSession().save(model);
    }
}
