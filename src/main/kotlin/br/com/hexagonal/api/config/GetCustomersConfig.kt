package br.com.hexagonal.api.config

import br.com.hexagonal.api.adapters.out.GetCustomersAdapter
import br.com.hexagonal.api.application.core.useCase.GetCustomersUseCase
import br.com.hexagonal.api.application.ports.`in`.GetCustomersInputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GetCustomersConfig {

    @Bean
    fun GetCustomers(getCustomersAdapter: GetCustomersAdapter):
            GetCustomersInputPort = GetCustomersUseCase(getCustomersAdapter)

}