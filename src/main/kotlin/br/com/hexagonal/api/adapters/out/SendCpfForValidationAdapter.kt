package br.com.hexagonal.api.adapters.out

import br.com.hexagonal.api.application.ports.out.SendCpfForValidationOutputPort
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class SendCpfForValidationAdapter(
    private val kafkaTemplate: KafkaTemplate<String, String>,
) : SendCpfForValidationOutputPort {
    override fun send(cpf: String) {
        kafkaTemplate.send("to-cpf-validation", cpf)
    }
}