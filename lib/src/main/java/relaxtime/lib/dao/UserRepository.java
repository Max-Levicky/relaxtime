package relaxtime.lib.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import relaxtime.lib.model.User;

import java.util.List;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@Repository
public class UserRepository {
//    @Autowired
//    private MongoOperations mongoOperations;

    private static final int UNRELAXED_LIMIT = 10;

    public User getCurrentUser(String name) {
//        Query query = new Query(Criteria.where("userName").is(name));
//        return mongoOperations.findOne(query, User.class);
        return null;
    }

    public List<User> getMostUnrelaxed() {
//        Query query = new Query();
//        query.limit(UNRELAXED_LIMIT);
//        query.with(new Sort(Direction.DESC, "lastRelaxTime"));
//        return mongoOperations.find(query, User.class);
        return null;
    }

//    @Override
//    protected String getSeqName() {
//        return UserRepository.class.getName();
//    }
}
