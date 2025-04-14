package br.com.hexagonal.api.adapters.`in`.controller

import br.com.hexagonal.api.adapters.`in`.controller.request.CustomerRequest
import br.com.hexagonal.api.adapters.`in`.controller.response.CustomerResponse
import br.com.hexagonal.api.application.core.domain.Customer
import br.com.hexagonal.api.application.ports.`in`.*
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(
    private val insertCustomerInputPort: InsertCustomerInputPort,
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val updateCustomerInputPort: UpdateCustomerInputPort,
    private val getCustomersInputPort: GetCustomersInputPort,
    private val deleteCustomerInputPort: DeleteCustomerInputPort,
) {

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    fun getAll(): List<Customer>? {
        return getCustomersInputPort.find()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun insert(@Valid @RequestBody customerRequest: CustomerRequest) {
        with(customerRequest) {
            val customer = Customer(name = name, cpf = cpf)
            insertCustomerInputPort.insert(customer, zipCode)
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id: String): CustomerResponse {
        val customer = findCustomerByIdInputPort.find(id)
        return CustomerResponse(customer)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: String, @Valid @RequestBody customerRequest: CustomerRequest) {
        with(customerRequest) {
            val customer = Customer(id, name, cpf = cpf)
            updateCustomerInputPort.update(customer, zipCode)
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) {
        deleteCustomerInputPort.delete(id)
    }

}