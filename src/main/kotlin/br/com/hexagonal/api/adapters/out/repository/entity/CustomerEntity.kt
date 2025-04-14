package br.com.hexagonal.api.adapters.out.repository.entity

import br.com.hexagonal.api.application.core.domain.Customer
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId

@Document(collection = "customers")
data class CustomerEntity(
    @MongoId
    val id: String? = null,
    val name: String,
    var address: AddressEntity,
    val cpf: String,
    val isValidCpf: Boolean,
) {
    constructor(customer: Customer) : this(
        customer.id,
        customer.name,
        AddressEntity(customer.address!!),
        customer.cpf,
        customer.isValidCpf
    )

    fun toCostumer() = Customer(id, name, address.toAddress(), cpf, isValidCpf)
}
