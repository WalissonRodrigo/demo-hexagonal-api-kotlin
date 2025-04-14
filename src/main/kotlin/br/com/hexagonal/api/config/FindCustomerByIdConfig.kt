package br.com.hexagonal.api.config

import br.com.hexagonal.api.adapters.out.FindCustomerByIdAdapter
import br.com.hexagonal.api.application.core.useCase.FindCustomerByIdUseCase
import br.com.hexagonal.api.application.ports.`in`.FindCustomerByIdInputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FindCustomerByIdConfig {

    @Bean
    fun findCustomerById(findCustomerByIdAdapter: FindCustomerByIdAdapter):
            FindCustomerByIdInputPort = FindCustomerByIdUseCase(findCustomerByIdAdapter)

}