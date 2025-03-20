package br.com.hexagonal.api.application.core.useCase

import br.com.hexagonal.api.application.core.domain.Customer
import br.com.hexagonal.api.application.ports.`in`.GetCustomersInputPort
import br.com.hexagonal.api.application.ports.out.GetCustomersOutputPort

class GetCustomersUseCase ( private val getCustomersOutputPort: GetCustomersOutputPort ): GetCustomersInputPort {

     override fun find(): List<Customer> = getCustomersOutputPort.find()

}