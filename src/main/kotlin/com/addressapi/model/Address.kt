package com.addressapi.model

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "address")
data class Address(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id_address: Int? = null,
    val uuid_address: UUID? = UUID.randomUUID(),
    var street: String,
    var address_number: Int,
    var neighborhood: String,
    var city: String,
    val states: String,
    val country: String,
    val zipcode: String
)