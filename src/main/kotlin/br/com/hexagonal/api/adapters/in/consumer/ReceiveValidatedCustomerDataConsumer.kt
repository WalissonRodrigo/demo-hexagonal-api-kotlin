package br.com.hexagonal.api.adapters.`in`.consumer

import br.com.hexagonal.api.adapters.`in`.consumer.message.CustomerMessage
import br.com.hexagonal.api.application.ports.`in`.UpdateCustomerInputPort
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class ReceiveValidatedCustomerDataConsumer(
    private val updateCustomerInputPort: UpdateCustomerInputPort,
) {
    @KafkaListener(topics = ["to-cpf-validated"], groupId = "api.hexagonal")
    fun receive(customerMessage: CustomerMessage) {
        with(customerMessage) {
            updateCustomerInputPort.update(toCustomer(), zipCode)
        }
    }
}