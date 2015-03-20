package relaxtime.lib.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import relaxtime.lib.model.User;

import java.util.List;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@Repository
public class UserRepository extends MongoRepository<User> {
    @Autowired
    private MongoOperations mongoOperations;

    private static final int UNRELAXED_LIMIT = 10;

    public User getCurrentUser(String name) {
        Query query = new Query(Criteria.where("userName").is(name));
        return mongoOperations.findOne(query, User.class);
    }

    public List<User> getMostUnrelaxed() {
        Query query = new Query();
        query.limit(UNRELAXED_LIMIT);
        query.with(new Sort(Direction.DESC, "lastRelaxTime"));
        return mongoOperations.find(query, User.class);
    }

    @Override
    protected String getSeqName() {
        return UserRepository.class.getName();
    }
}
