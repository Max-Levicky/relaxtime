package relaxtime.lib.jms.activeMqImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import relaxtime.lib.jms.Message;
import relaxtime.lib.jms.Sender;

import javax.jms.Queue;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
public class ActiveMqSender implements Sender {
    @Autowired
    private Queue queue;
    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void send(Message message) {

    }
}
