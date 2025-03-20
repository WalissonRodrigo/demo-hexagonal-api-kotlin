package br.com.hexagonal.api.application.core.domain

data class Address(
    val street: String,
    val city: String,
    val state: String,
    val zipCode: String
)
