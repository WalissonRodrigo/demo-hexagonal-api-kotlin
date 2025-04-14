package br.com.hexagonal.api.adapters.out.client.response

import br.com.hexagonal.api.application.core.domain.Address

data class AddressResponse(
    val street: String,
    val city: String,
    val state: String,
    val zipCode: String,
) {
    fun toAddress() = Address(street = street, city = city, state = state, zipCode = zipCode)
}
