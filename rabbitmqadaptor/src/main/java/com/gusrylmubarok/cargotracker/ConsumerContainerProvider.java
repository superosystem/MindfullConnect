package com.gusrylmubarok.cargotracker;


import com.gusrylmubarok.cargotracker.consumer.ConsumerContainer;
import com.rabbitmq.client.ConnectionFactory;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Provides the default consumer container.
 *
 * @author christian.bick
 */
public class ConsumerContainerProvider {

    @Inject
    ConnectionFactory connectionFactory;

    @Produces @Singleton
    public ConsumerContainer provideConsumerContainer() {
        return new ConsumerContainer(connectionFactory);
    }

}
