package bugReport2;

import io.micronaut.context.annotation.Value;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

@MicronautTest(transactional = false)
public class SendingTest {

    @Inject
    private BrokerSender brokerSender;

    @Value("${rabbitmq.routing-key}")
    private String routingKey;

    @Test
    public void test() {
        Mono.just("irrelevant")
            .flatMap((s) -> brokerSender
                    .send(routingKey, s)
                    .then())
            .block();
    }
}
