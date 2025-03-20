package br.com.hexagonal.api.config

import br.com.hexagonal.api.adapters.out.FindAddressByZipCodeAdapter
import br.com.hexagonal.api.adapters.out.FindCustomerByIdAdapter
import br.com.hexagonal.api.adapters.out.InsertCustomerAdapter
import br.com.hexagonal.api.adapters.out.UpdateCustomerAdapter
import br.com.hexagonal.api.application.core.useCase.FindCustomerByIdUseCase
import br.com.hexagonal.api.application.core.useCase.UpdateCustomerUseCase
import br.com.hexagonal.api.application.ports.`in`.FindCustomerByIdInputPort
import br.com.hexagonal.api.application.ports.`in`.UpdateCustomerInputPort
import br.com.hexagonal.api.application.ports.out.FindCustomerByIdOutputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UpdateCustomerConfig {

    @Bean
    fun updateCustomer(
        findCustomerByIdUseCase: FindCustomerByIdUseCase,
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        updateCustomerAdapter: UpdateCustomerAdapter,
    ) = UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter)

}