package relaxtime.lib.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import relaxtime.lib.model.Event;

import java.util.List;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@Repository
public class EventRepository extends MongoRepository<Event> implements IEventRepository {
    @Autowired
    private MongoOperations mongoOperation;

    public List<Event> getUserEvents(Long userId) {
        Query query = new Query(Criteria.where("userId").is(userId));
        return mongoOperation.find(query, Event.class);
    }

    @Override
    protected String getSeqName() {
        return EventRepository.class.getName();
    }
}
