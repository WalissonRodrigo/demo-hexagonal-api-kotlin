package br.com.hexagonal.api.application.core.useCase

import br.com.hexagonal.api.application.core.domain.Customer
import br.com.hexagonal.api.application.core.exceptions.ObjectNotFoundException
import br.com.hexagonal.api.application.ports.`in`.FindCustomerByIdInputPort
import br.com.hexagonal.api.application.ports.out.FindCustomerByIdOutputPort

class FindCustomerByIdUseCase(
    private val findCustomerByIdOutputPort: FindCustomerByIdOutputPort,

    ) : FindCustomerByIdInputPort {

    override fun find(id: String): Customer =
        findCustomerByIdOutputPort.find(id) ?: throw ObjectNotFoundException("Customer not found")

}