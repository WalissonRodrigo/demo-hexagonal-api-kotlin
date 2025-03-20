package br.com.hexagonal.api.adapters.out.repository.entity

import br.com.hexagonal.api.application.core.domain.Address

data class AddressEntity(
    val street: String,
    val city: String,
    val state: String,
    val zipCode: String
) {
    constructor(address: Address): this(
        address.street,
        address.city,
        address.state,
        address.zipCode
    )

    fun toAddress() = Address(street, city, state, zipCode)
}
