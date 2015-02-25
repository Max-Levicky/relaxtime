package relaxtime.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@Document(collection = "sequence")
public class SequenceId {
    @Id
    private String id;

    private long seq;

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }
}
