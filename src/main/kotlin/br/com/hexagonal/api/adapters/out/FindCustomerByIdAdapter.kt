package br.com.hexagonal.api.adapters.out

import br.com.hexagonal.api.adapters.out.repository.CustomerRepository
import br.com.hexagonal.api.application.core.domain.Customer
import br.com.hexagonal.api.application.ports.out.FindCustomerByIdOutputPort
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class FindCustomerByIdAdapter(
    private val customerRepository: CustomerRepository,
) : FindCustomerByIdOutputPort {
    override fun find(id: String): Customer? =
        customerRepository
            .findById(id)
            .getOrNull()
            .let { return it?.toCostumer() }
}