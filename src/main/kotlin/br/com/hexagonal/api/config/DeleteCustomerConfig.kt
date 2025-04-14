package br.com.hexagonal.api.config

import br.com.hexagonal.api.application.core.useCase.DeleteCustomerUseCase
import br.com.hexagonal.api.application.ports.`in`.FindCustomerByIdInputPort
import br.com.hexagonal.api.application.ports.out.DeleteCustomerOutputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DeleteCustomerConfig {

    @Bean
    fun deleteCustomer(
        findCustomerByIdInputPort: FindCustomerByIdInputPort,
        deleteCustomerOutputPort: DeleteCustomerOutputPort,
    ) = DeleteCustomerUseCase(
        findCustomerByIdInputPort,
        deleteCustomerOutputPort
    )

}