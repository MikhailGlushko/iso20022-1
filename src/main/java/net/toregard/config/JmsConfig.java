package net.toregard.config;

import org.apache.camel.component.jms.JmsComponent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.connection.JmsTransactionManager;

import javax.jms.ConnectionFactory;

/**
 * Created by toanders on 06.01.2017.
 */
@Configuration
public class JmsConfig{
//    @Value("${jms.MaxConcurrentConsumers}")
//    private int MaxConcurrentConsumers;
//
//    @Bean
//    public JmsTransactionManager createTransactionmanager(final ConnectionFactory connectionFactory){
//        JmsTransactionManager jmsTransactionManager = new JmsTransactionManager();
//        jmsTransactionManager.setConnectionFactory(connectionFactory);
//        return jmsTransactionManager;
//    }
//
//
//    @Bean
//    public JmsComponent createJmsComponent(final ConnectionFactory connectionFactory,
//                                           final  JmsTransactionManager jmsTransactionManager){
//        JmsComponent jmsComponent = JmsComponent.jmsComponentTransacted(connectionFactory,jmsTransactionManager);
//        jmsComponent.setMaxConcurrentConsumers(MaxConcurrentConsumers);
//        return jmsComponent;
//    }


//    @Bean
//    public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
//                                                    DefaultJmsListenerContainerFactoryConfigurer configurer) {
//        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//        // This provides all boot's default to this factory, including the message converter
//        configurer.configure(factory, connectionFactory);
//        // You could still override some of Boot's default if necessary.
//        return factory;
//    }

}
