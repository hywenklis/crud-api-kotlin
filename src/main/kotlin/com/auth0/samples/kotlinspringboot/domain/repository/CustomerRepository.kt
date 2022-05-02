package com.auth0.samples.kotlinspringboot.domain.repository

import com.auth0.samples.kotlinspringboot.domain.model.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, Long>