package relaxtime.lib.dao;

import com.google.common.util.concurrent.Striped;
import org.springframework.beans.factory.annotation.Autowired;
import relaxtime.lib.model.MongoFilter;
import relaxtime.lib.model.MongoModel;

import java.util.concurrent.locks.Lock;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
abstract public class MongoRepository<T extends MongoModel> {
//    @Autowired
//    protected MongoOperations mongoOperations;
//    private Striped<Lock> locks = Striped.lock(10);

    public void save(T event) {
//        if (event.getId() < 1) {
//            event.setId(getNextId());
//        }
//        mongoOperations.save(event);
    }

    protected Long getNextId() {
//        String seqName = getSeqName();
//        Lock lock = locks.get(seqName);
//        try {
//            lock.tryLock();
//
//            Query query = new Query(Criteria.where("id").is(seqName));
//
//            //increase sequence id by 1
//            Update update = new Update();
//            update.inc("seq", 1);
//
//            //return new increased id
//            FindAndModifyOptions options = FindAndModifyOptions.options().returnNew(true);
//
//            //this is the magic happened.
//            SequenceId seqId = mongoOperations.findAndModify(query, update, options, SequenceId.class);
//
//            //if no id, throws SequenceException
//            //optional, just a way to tell user when the sequence id is failed to generate.
//            if (seqId == null) {
//                throw new RuntimeException("Unable to get sequence id for key: " + seqName);
//            }
//
//            return seqId.getSeq();
//        } finally {
//            lock.unlock();
//        }
        return null;
    }

//    protected abstract String getSeqName();
}
