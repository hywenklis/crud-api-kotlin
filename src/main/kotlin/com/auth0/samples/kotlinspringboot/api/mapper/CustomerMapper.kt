package com.auth0.samples.kotlinspringboot.api.mapper

import com.auth0.samples.kotlinspringboot.api.request.CreateCustomerRequest
import com.auth0.samples.kotlinspringboot.api.request.UpdateCustomerRequest
import com.auth0.samples.kotlinspringboot.api.response.CustomerResponse
import com.auth0.samples.kotlinspringboot.domain.model.Customer
import org.springframework.stereotype.Component

@Component
class CustomerMapper {

    fun convertCreateCustomerRequestToCustomer(createCustomerRequest: CreateCustomerRequest): Customer {
        return Customer(
            id = null,
            firstName = createCustomerRequest.name,
            dateOfBirth = createCustomerRequest.dateOfBirth,
            cpf = createCustomerRequest.cpf,
            email = createCustomerRequest.email
        )
    }

    fun convertUpdateCustomerRequestToCustomer(
        updateCustomerRequest: UpdateCustomerRequest,
        customer: Customer
    ): Customer {
        return customer.copy(
            firstName = updateCustomerRequest.name,
            dateOfBirth = updateCustomerRequest.dateOfBirth,
            cpf = updateCustomerRequest.cpf,
            email = updateCustomerRequest.email
        )
    }

    fun convertCustomerToCustomerResponse(customer: Customer): CustomerResponse {
        return CustomerResponse(
            id = customer.id!!,
            name = customer.firstName,
            dateOfBirth = customer.dateOfBirth,
            cpf = customer.cpf,
            email = customer.email
        )
    }
}