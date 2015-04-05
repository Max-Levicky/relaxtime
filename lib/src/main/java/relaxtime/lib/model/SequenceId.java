package relaxtime.lib.model;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
//@Document(collection = "sequence")
public class SequenceId {
//    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private long seq;

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }
}
