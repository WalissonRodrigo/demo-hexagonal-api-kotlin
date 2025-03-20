package br.com.hexagonal.api.application.ports.out

import br.com.hexagonal.api.application.core.domain.Customer

interface UpdateCustomerOutputPort {

    fun update (customer: Customer)

}