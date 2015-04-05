package relaxtime.lib.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import relaxtime.lib.model.User;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@Repository
public class UserRepository extends HibernateRepository<User> {
    @Autowired
    private SessionFactory sessionFactory;

    private static final int UNRELAXED_LIMIT = 10;

    public User getUserByName(String name) {
//        Query query = new Query(Criteria.where("userName").is(name));
//        return mongoOperations.findOne(query, User.class);
        return null;
    }

    @SuppressWarnings("unchecked")
    public List<User> getMostUnrelaxed() {
        return getSession().createCriteria(User.class)
                .add(Restrictions.eq("relaxStatus", "WORKING"))
                .addOrder(Order.desc("lastRelaxTime"))
                .setMaxResults(UNRELAXED_LIMIT)
                .list();
    }

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

//    @Override
//    protected String getSeqName() {
//        return UserRepository.class.getName();
//    }
}
