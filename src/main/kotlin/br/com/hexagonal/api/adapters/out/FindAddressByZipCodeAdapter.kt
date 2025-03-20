package br.com.hexagonal.api.adapters.out

import br.com.hexagonal.api.adapters.out.client.FindAddressByZipCodeClient
import br.com.hexagonal.api.application.core.domain.Address
import br.com.hexagonal.api.application.ports.out.FindAddressByZipCodeOutputPort
import org.springframework.stereotype.Component

@Component
class FindAddressByZipCodeAdapter(
    private val findAddressByZipCodeClient: FindAddressByZipCodeClient
): FindAddressByZipCodeOutputPort {

    override fun find(zipCode: String): Address = findAddressByZipCodeClient.find(zipCode).toAddress()

}