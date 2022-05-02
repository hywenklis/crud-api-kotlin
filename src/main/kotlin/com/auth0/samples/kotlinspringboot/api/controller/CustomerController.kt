package com.auth0.samples.kotlinspringboot.api.controller

import com.auth0.samples.kotlinspringboot.api.request.CreateCustomerRequest
import com.auth0.samples.kotlinspringboot.api.request.UpdateCustomerRequest
import com.auth0.samples.kotlinspringboot.api.response.CustomerResponse
import com.auth0.samples.kotlinspringboot.domain.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customers")
class CustomerController(val service: CustomerService) {

    @GetMapping
    fun findByAll(): ResponseEntity<List<CustomerResponse>> {
        return ResponseEntity.ok(service.findByAll())
    }

    @PostMapping
    fun save(@RequestBody createCustomerRequest: CreateCustomerRequest): ResponseEntity<CustomerResponse>  {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(createCustomerRequest))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody updateCustomerRequest: UpdateCustomerRequest): ResponseEntity<CustomerResponse> {
        return ResponseEntity.ok(service.update(id, updateCustomerRequest))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }
}

