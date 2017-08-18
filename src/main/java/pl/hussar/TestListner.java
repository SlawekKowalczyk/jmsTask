package pl.hussar;

import org.springframework.jms.annotation.JmsListener;

/**
 * @author Sławomir Kowalczyk.
 */
public class TestListner {

    @JmsListener(destination = JmsConfig.TOPIC,containerFactory = "myFactory")
    public void receive(String msg) {
        System.out.println(msg);
    }
}
