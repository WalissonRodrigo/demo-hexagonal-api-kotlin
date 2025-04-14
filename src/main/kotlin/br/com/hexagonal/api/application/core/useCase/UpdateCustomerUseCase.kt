package br.com.hexagonal.api.application.core.useCase

import br.com.hexagonal.api.application.core.domain.Customer
import br.com.hexagonal.api.application.ports.`in`.FindCustomerByIdInputPort
import br.com.hexagonal.api.application.ports.`in`.UpdateCustomerInputPort
import br.com.hexagonal.api.application.ports.out.FindAddressByZipCodeOutputPort
import br.com.hexagonal.api.application.ports.out.SendCpfForValidationOutputPort
import br.com.hexagonal.api.application.ports.out.UpdateCustomerOutputPort

class UpdateCustomerUseCase(
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val updateCustomerOutputPort: UpdateCustomerOutputPort,
    private val sendCpfForValidationOutputPort: SendCpfForValidationOutputPort
): UpdateCustomerInputPort {

    override fun update(customer: Customer, zipCode: String) {
        if (customer.id == null) throw IllegalArgumentException("The ID field cannot be null")
        val savedCpf = findCustomerByIdInputPort.find(customer.id).cpf
        customer.apply {
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let {
            updateCustomerOutputPort.update(it)
            if (savedCpf != it.cpf) {
                sendCpfForValidationOutputPort.send(it.cpf)
            }
        }
    }
}