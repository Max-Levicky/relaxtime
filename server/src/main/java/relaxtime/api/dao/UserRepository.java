package relaxtime.api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import relaxtime.lib.model.Event;
import relaxtime.lib.model.User;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@Repository
public class UserRepository extends MongoRepository<User> {
    @Autowired
    private MongoOperations mongoOperations;
    public User getCurrentUser(String name) {
        Query query = new Query(Criteria.where("userName").is(name));
        return mongoOperations.findOne(query, User.class);
    }

    @Override
    protected String getSeqName() {
        return UserRepository.class.getName();
    }
}
