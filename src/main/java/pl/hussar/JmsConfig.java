package pl.hussar;

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

/**
 * @author Sławomir Kowalczyk.
 */
@Configuration
@EnableJms
public class JmsConfig {
    public static final String TOPIC = "Example.Library.Publication";

    @Bean
    public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
                                                    DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        return factory;
    }

    @Bean
    public TestListner testListner1() {
        return new TestListner();
    }

    @Bean
    public TestListner testListner2() {
        return new TestListner();
    }
    @Bean
    public TestListner testListner3() {
        return new TestListner();
    }
}
