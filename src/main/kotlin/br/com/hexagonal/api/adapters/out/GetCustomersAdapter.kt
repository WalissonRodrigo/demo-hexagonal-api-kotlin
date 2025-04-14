package br.com.hexagonal.api.adapters.out

import br.com.hexagonal.api.adapters.out.repository.CustomerRepository
import br.com.hexagonal.api.application.core.domain.Customer
import br.com.hexagonal.api.application.ports.out.GetCustomersOutputPort
import org.springframework.stereotype.Component

@Component
class GetCustomersAdapter(
    private val customerRepository: CustomerRepository,
) : GetCustomersOutputPort {
    override fun find(): List<Customer> =
        customerRepository
            .findAll()
            .map { it.toCostumer() }

}