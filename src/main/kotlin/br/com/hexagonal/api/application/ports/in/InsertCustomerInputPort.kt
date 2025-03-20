package br.com.hexagonal.api.application.ports.`in`

import br.com.hexagonal.api.application.core.domain.Customer

interface InsertCustomerInputPort {

    fun insert(customer: Customer, zipCode: String)

}