package br.com.hexagonal.api.application.ports.out

interface SendCpfForValidationOutputPort {
    fun send(cpf: String)
}