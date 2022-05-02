package com.auth0.samples.kotlinspringboot.api.request

import java.time.LocalDate

data class UpdateCustomerRequest(
    val name: String,
    val dateOfBirth: LocalDate,
    val cpf: String,
    val email: String
)
