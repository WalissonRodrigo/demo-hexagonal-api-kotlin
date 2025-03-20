package br.com.hexagonal.api.application.core.useCase

import br.com.hexagonal.api.application.core.domain.Customer
import br.com.hexagonal.api.application.ports.`in`.FindCustomerByIdInputPort
import br.com.hexagonal.api.application.ports.`in`.UpdateCustomerInputPort
import br.com.hexagonal.api.application.ports.out.FindAddressByZipCodeOutputPort
import br.com.hexagonal.api.application.ports.out.UpdateCustomerOutputPort

class UpdateCustomerUseCase(
    private val findCustomerByInputPort: FindCustomerByIdInputPort,
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val updateCustomerOutputPort: UpdateCustomerOutputPort
): UpdateCustomerInputPort {

    override fun update(customer: Customer, zipCode: String) {
        if (customer.id == null) throw IllegalArgumentException("The ID field cannot be null")
        findCustomerByInputPort.find(customer.id)
        customer.apply {
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let {
            updateCustomerOutputPort.update(it)
        }

    }
}