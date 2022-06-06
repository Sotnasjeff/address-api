package com.addressapi.dto


class AddressUpdateDTO(
    val id: Int,
    val street: String,
    val address_number: Int,
    val neighborhood: String,
    val city: String
) {
}