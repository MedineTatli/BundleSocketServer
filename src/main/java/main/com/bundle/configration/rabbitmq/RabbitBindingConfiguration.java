package main.com.bundle.configration.rabbitmq;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class RabbitBindingConfiguration {

    @Bean
    public Binding bundleDataBinding(Queue bundleDataQueue, DirectExchange bundleDataExchange) {
        return BindingBuilder
                .bind(bundleDataQueue)
                .to(bundleDataExchange)
                .with("ROUTING_KEY_BUNDLE_DATA");
    }
}