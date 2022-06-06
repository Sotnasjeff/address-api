package com.addressapi.dto

data class AddressDTO(
    val id_address: Int?,
    val street: String,
    val address_number: Int,
    val neighborhood: String,
    val city: String,
    val states: String,
)