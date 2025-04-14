package br.com.hexagonal.api.adapters.`in`.controller.response

import br.com.hexagonal.api.application.core.domain.Address

data class AddressResponse(
    val street: String,
    val city: String,
    val state: String,
    val zipCode: String,
) {
    constructor(address: Address) : this(
        address.street,
        address.city,
        address.state,
        address.zipCode
    )

    fun toAddress() = Address(street, city, state, zipCode)
}
