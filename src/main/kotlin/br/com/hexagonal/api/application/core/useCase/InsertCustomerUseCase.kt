package br.com.hexagonal.api.application.core.useCase

import br.com.hexagonal.api.application.core.domain.Customer
import br.com.hexagonal.api.application.ports.`in`.InsertCustomerInputPort
import br.com.hexagonal.api.application.ports.out.FindAddressByZipCodeOutputPort
import br.com.hexagonal.api.application.ports.out.InsertCustomerOutputPort
import br.com.hexagonal.api.application.ports.out.SendCpfForValidationOutputPort

class InsertCustomerUseCase(
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val insertCustomerOutputPort: InsertCustomerOutputPort,
    private val sendCpfForValidationOutputPort: SendCpfForValidationOutputPort,
) : InsertCustomerInputPort {
    override fun insert(customer: Customer, zipCode: String) {
        customer.apply {
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let {
            insertCustomerOutputPort.insert(it)
            sendCpfForValidationOutputPort.send(it.cpf)
        }
    }
}