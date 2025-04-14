package br.com.hexagonal.api.config

import br.com.hexagonal.api.adapters.out.FindAddressByZipCodeAdapter
import br.com.hexagonal.api.adapters.out.SendCpfForValidationAdapter
import br.com.hexagonal.api.adapters.out.UpdateCustomerAdapter
import br.com.hexagonal.api.application.core.useCase.UpdateCustomerUseCase
import br.com.hexagonal.api.application.ports.`in`.FindCustomerByIdInputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UpdateCustomerConfig {

    @Bean
    fun updateCustomer(
        findCustomerByIdInputPort: FindCustomerByIdInputPort,
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        updateCustomerAdapter: UpdateCustomerAdapter,
        sendCpfForValidationAdapter: SendCpfForValidationAdapter,
    ) = UpdateCustomerUseCase(
        findCustomerByIdInputPort,
        findAddressByZipCodeAdapter,
        updateCustomerAdapter,
        sendCpfForValidationAdapter
    )

}