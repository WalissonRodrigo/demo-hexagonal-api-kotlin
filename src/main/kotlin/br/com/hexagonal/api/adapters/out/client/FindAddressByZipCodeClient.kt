package br.com.hexagonal.api.adapters.out.client

import br.com.hexagonal.api.adapters.out.client.response.AddressResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

//"\${hexagonal.client.address.url}"
@FeignClient(
    name = "FindAddressByZipCodeClient",
    url = "\${hexagonal.client.address.url}"
)
interface FindAddressByZipCodeClient {

    @GetMapping("/{zipCode}")
    fun find(@PathVariable zipCode: String): AddressResponse
}