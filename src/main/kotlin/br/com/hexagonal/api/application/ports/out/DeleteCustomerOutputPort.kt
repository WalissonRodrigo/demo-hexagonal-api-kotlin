package br.com.hexagonal.api.application.ports.out

interface DeleteCustomerOutputPort {

    fun delete(id: String)

}