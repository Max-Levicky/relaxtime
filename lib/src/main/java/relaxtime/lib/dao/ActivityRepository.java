package relaxtime.lib.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import relaxtime.lib.model.Activity;
import relaxtime.lib.model.Event;
import relaxtime.lib.model.User;

import java.util.List;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@Repository
public class ActivityRepository extends HibernateRepository<Activity> {
//    @Autowired
//    private MongoOperations mongoOperations;
    @Autowired
    private SessionFactory sessionFactory;

    public List<Activity> getAvailableActivities(List<User> users) {
//        Query query = new Query(Criteria.where("busy").is(false));
//        return mongoOperations.find(query, Activity.class);
        return null;
    }

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

//    @Override
//    protected String getSeqName() {
//        return ActivityRepository.class.getName();
//    }
}
