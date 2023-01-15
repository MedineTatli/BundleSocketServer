package main.com.bundle.configration.rabbitmq;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@RequiredArgsConstructor
@Configuration
public class RabbitExchangeConfiguration {

    @Bean
    public DirectExchange bundleDataExchange() {
        return new DirectExchange("bundleDataExchange");
    }
}