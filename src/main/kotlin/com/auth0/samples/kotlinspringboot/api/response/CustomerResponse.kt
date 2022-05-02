package com.auth0.samples.kotlinspringboot.api.response

import java.time.LocalDate

data class CustomerResponse(
    val id: Long,
    val name: String,
    val dateOfBirth: LocalDate,
    val cpf: String,
    val email: String
)
