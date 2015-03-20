package relaxtime.lib.dao;

import com.google.common.util.concurrent.Striped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import relaxtime.lib.model.MongoFilter;
import relaxtime.lib.model.MongoModel;
import relaxtime.lib.model.SequenceId;

import java.util.concurrent.locks.Lock;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
abstract public class MongoRepository<T extends MongoModel> {
    @Autowired
    protected MongoOperations mongoOperations;
    private Striped<Lock> locks = Striped.lock(10);

    public void save(T event) {
        if (event.getId() < 1) {
            event.setId(getNextId());
        }
        mongoOperations.save(event);
    }

    protected Long getNextId() {
        String seqName = getSeqName();
        Lock lock = locks.get(seqName);
        try {
            lock.lock();

            Query query = new Query(Criteria.where("_id").is(seqName));

            //increase sequence id by 1
            Update update = new Update();
            update.inc("seq", 1);

            //return new increased id
            FindAndModifyOptions options = new FindAndModifyOptions();
            options.returnNew(true);

            //this is the magic happened.
            SequenceId seqId = mongoOperations.findAndModify(query, update, options, SequenceId.class);

            //if no id, throws SequenceException
            //optional, just a way to tell user when the sequence id is failed to generate.
            if (seqId == null) {
                throw new RuntimeException("Unable to get sequence id for key : " + seqName);
            }

            return seqId.getSeq();
        } finally {
            lock.unlock();
        }
    }

    protected abstract String getSeqName();
}
