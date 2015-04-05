package relaxtime.lib.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import relaxtime.lib.model.Event;

import java.util.List;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@Repository
public class EventRepository extends HibernateRepository<Event> implements IEventRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Event> getUserEvents(Long userId) {
        return getSession().createCriteria(Event.class)
                .add(Restrictions.eq("targetUser.id", userId))
                .list();
    }

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
