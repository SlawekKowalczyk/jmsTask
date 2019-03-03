package pl.hussar;

import org.springframework.jms.annotation.JmsListener;

public class TestListener {

    @JmsListener(destination = JmsConfig.TOPIC, containerFactory = "myFactory")
    public void receive(String msg) {
        System.out.println(msg);
    }
}
