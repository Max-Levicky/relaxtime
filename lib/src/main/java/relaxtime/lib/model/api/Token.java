package relaxtime.lib.model.api;

import relaxtime.lib.model.User;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Max Levicky
 */
@Entity
@Table(name = "tokens")
@NamedQueries({
        @NamedQuery(
                name = Token.FIND_BY_TOKEN,
                query = "from Token t where t.token = ?"
        ),
})
public class Token implements Serializable {
    @Id
    private String token;
    @ManyToOne
    private User user;
    public static final String FIND_BY_TOKEN = "Token.findByToken";

    public Token() {
    }

    public Token(String token, User user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
