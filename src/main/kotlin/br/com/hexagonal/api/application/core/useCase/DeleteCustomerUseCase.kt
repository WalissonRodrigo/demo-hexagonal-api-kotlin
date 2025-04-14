package br.com.hexagonal.api.application.core.useCase

import br.com.hexagonal.api.application.ports.`in`.DeleteCustomerInputPort
import br.com.hexagonal.api.application.ports.`in`.FindCustomerByIdInputPort
import br.com.hexagonal.api.application.ports.out.DeleteCustomerOutputPort

class DeleteCustomerUseCase(
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val deleteCustomerOutputPort: DeleteCustomerOutputPort,
) : DeleteCustomerInputPort {

    override fun delete(id: String) {
        findCustomerByIdInputPort.find(id)
        deleteCustomerOutputPort.delete(id)
    }
}