package com.auth0.samples.kotlinspringboot.domain.service

import com.auth0.samples.kotlinspringboot.api.mapper.CustomerMapper
import com.auth0.samples.kotlinspringboot.api.request.CreateCustomerRequest
import com.auth0.samples.kotlinspringboot.api.request.UpdateCustomerRequest
import com.auth0.samples.kotlinspringboot.api.response.CustomerResponse
import com.auth0.samples.kotlinspringboot.domain.model.Customer
import com.auth0.samples.kotlinspringboot.domain.repository.CustomerRepository
import com.auth0.samples.kotlinspringboot.exception.ObjectNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerRepository: CustomerRepository, private val customerMapper: CustomerMapper) {

    fun findByAll(): List<CustomerResponse> {
        return customerRepository.findAll().map { customerMapper.convertCustomerToCustomerResponse(it) }
    }

    fun save(createCustomerRequest: CreateCustomerRequest): CustomerResponse? {
        val customer = customerMapper.convertCreateCustomerRequestToCustomer(createCustomerRequest)
        return customerMapper.convertCustomerToCustomerResponse(customerRepository.save(customer))
    }

    fun update(id: Long, updateCustomerRequest: UpdateCustomerRequest): CustomerResponse {
        val customerSaved = exist(id)
        val customer = customerMapper.convertUpdateCustomerRequestToCustomer(updateCustomerRequest, customerSaved)
        return customerMapper.convertCustomerToCustomerResponse(customerRepository.save(customer))
    }

    fun delete(id: Long) {
        customerRepository.deleteById(id)
    }

    private fun exist(id: Long): Customer {
        return customerRepository.findById(id)
            .orElseThrow { ObjectNotFoundException("ID $id not found") }
    }
}