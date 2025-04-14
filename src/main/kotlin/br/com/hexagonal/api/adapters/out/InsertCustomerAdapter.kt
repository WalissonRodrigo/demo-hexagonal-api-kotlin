package br.com.hexagonal.api.adapters.out

import br.com.hexagonal.api.adapters.out.repository.CustomerRepository
import br.com.hexagonal.api.adapters.out.repository.entity.CustomerEntity
import br.com.hexagonal.api.application.core.domain.Customer
import br.com.hexagonal.api.application.ports.out.InsertCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class InsertCustomerAdapter(
    private val customerRepository: CustomerRepository,
) : InsertCustomerOutputPort {
    override fun insert(customer: Customer) {
        customerRepository.save(CustomerEntity(customer))
    }
}