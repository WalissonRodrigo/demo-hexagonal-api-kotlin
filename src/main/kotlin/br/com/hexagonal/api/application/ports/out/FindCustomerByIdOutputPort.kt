package br.com.hexagonal.api.application.ports.out

import br.com.hexagonal.api.application.core.domain.Customer

interface FindCustomerByIdOutputPort {

    fun find(id: String): Customer?

}