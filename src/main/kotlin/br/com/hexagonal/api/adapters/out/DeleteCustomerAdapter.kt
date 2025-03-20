package br.com.hexagonal.api.adapters.out

import br.com.hexagonal.api.adapters.out.repository.CustomerRepository
import br.com.hexagonal.api.application.ports.out.DeleteCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class DeleteCustomerAdapter(
    private val customerRepository: CustomerRepository
): DeleteCustomerOutputPort {

    override fun delete(id: String) = customerRepository.deleteById(id)

}