this is a demonstration of what seems to be a bug in either `micronaut-core` or `micronaut-rabbitmq` module.

a connection to a RabbitMQ broker is required, configurable in `application.yml`. the command to expose the bug: `mvn test`

sending a message to RabbitMQ fails with:

`java.lang.ClassCastException: class reactor.core.publisher.FluxOnErrorResume cannot be cast to class reactor.core.publisher.Mono (reactor.core.publisher.FluxOnErrorResume and reactor.core.publisher.Mono are in unnamed module of loader 'app')`