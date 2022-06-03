package bugReport2;

import io.micronaut.rabbitmq.annotation.Binding;
import io.micronaut.rabbitmq.annotation.RabbitClient;
import io.micronaut.rabbitmq.annotation.RabbitProperty;
import reactor.core.publisher.Mono;

@RabbitClient("${rabbitmq.exchange}")
public interface BrokerSender {

    // https://www.rabbitmq.com/publishers.html#message-properties
    @RabbitProperty(name = "contentType", value = "application/json")
    @RabbitProperty(name = "deliveryMode", value = "2")
    // returning a reactive type ensures the use of broker acknowledgement.
    Mono<Void> send(@Binding String type, String message);
}
