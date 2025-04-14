package br.com.hexagonal.api.application.ports.`in`

import br.com.hexagonal.api.application.core.domain.Customer

interface FindCustomerByIdInputPort {

    fun find(id: String): Customer

}