package relaxtime.lib.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import relaxtime.lib.model.api.Token;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.transaction.Transactional;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@Repository
@Transactional
public class TokenRepository extends HibernateRepository<Token> {
    @Autowired
    private SessionFactory sessionFactory;

    public boolean tokenExists(String token) {
        return null != findByToken(token);
    }

    public Token findByToken(String token) {
        return (Token) getSession()
                .getNamedQuery(Token.FIND_BY_TOKEN)
                .setString(0, token)
                .uniqueResult();
    }

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
