package br.com.hexagonal.api.application.ports.out

import br.com.hexagonal.api.application.core.domain.Address

interface FindAddressByZipCodeOutputPort {

    fun find(zipCode: String): Address

}