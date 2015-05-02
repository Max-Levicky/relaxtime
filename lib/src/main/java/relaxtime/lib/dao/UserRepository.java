package relaxtime.lib.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import relaxtime.lib.model.RelaxStatus;
import relaxtime.lib.model.User;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@Repository
@Transactional
public class UserRepository extends HibernateRepository<User> {
    @Autowired
    private SessionFactory sessionFactory;

    private static final int UNRELAXED_LIMIT = 10;

    public User getUserByName(String name) {
        return (User) getSession().createCriteria(User.class)
                .add(Restrictions.eq("username", name))
                .setMaxResults(1)
                .uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<User> getMostUnrelaxed() {
        return getSession().createCriteria(User.class)
                .add(Restrictions.eq("relaxStatus", RelaxStatus.WORKING))
                .addOrder(Order.desc("lastRelaxTime"))
                .setMaxResults(UNRELAXED_LIMIT)
                .list();
    }

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
