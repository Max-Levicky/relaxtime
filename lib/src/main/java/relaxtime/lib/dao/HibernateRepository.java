package relaxtime.lib.dao;

import org.hibernate.Session;

import javax.transaction.Transactional;
import java.io.Serializable;

/**
 * @author Max Levicky
 */
@Transactional
public abstract class HibernateRepository<T extends Serializable> {
    public abstract Session getSession();
    public void save(T model) {
        getSession().save(model);
    }

    public void update(T model) {
        getSession().update(model);
    }

    public void delete(T model) {
        getSession().delete(model);
    }
}
