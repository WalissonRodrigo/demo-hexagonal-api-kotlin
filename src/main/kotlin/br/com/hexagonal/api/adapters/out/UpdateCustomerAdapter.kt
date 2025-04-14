package br.com.hexagonal.api.adapters.out

import br.com.hexagonal.api.adapters.out.repository.CustomerRepository
import br.com.hexagonal.api.adapters.out.repository.entity.CustomerEntity
import br.com.hexagonal.api.application.core.domain.Customer
import br.com.hexagonal.api.application.ports.out.UpdateCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class UpdateCustomerAdapter(
    private val customerRepository: CustomerRepository,
) : UpdateCustomerOutputPort {
    override fun update(customer: Customer) {
        customerRepository.save(CustomerEntity(customer))
    }
}