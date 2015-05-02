package relaxtime.lib.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import relaxtime.lib.model.Activity;
import relaxtime.lib.model.Event;
import relaxtime.lib.model.User;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@Repository
@Transactional
public class ActivityRepository extends HibernateRepository<Activity> {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Activity> getAvailableActivities(List<User> users) {
        return null;
    }

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
