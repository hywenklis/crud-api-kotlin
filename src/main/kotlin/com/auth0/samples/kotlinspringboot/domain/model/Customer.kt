package com.auth0.samples.kotlinspringboot.domain.model

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "Customers")
data class Customer(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,
    val firstName: String,
    val dateOfBirth: LocalDate,
    val cpf: String,
    val email: String
)