package br.com.hexagonal.api.config

import br.com.hexagonal.api.adapters.out.FindAddressByZipCodeAdapter
import br.com.hexagonal.api.adapters.out.InsertCustomerAdapter
import br.com.hexagonal.api.application.core.useCase.InsertCustomerUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertCustomerConfig {
    @Bean
    fun insertCustomer(
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        insertCustomerAdapter: InsertCustomerAdapter
    ) = InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter)

}