package com.addressapi.mapper

import com.addressapi.dto.AddressDTO
import com.addressapi.model.Address
import org.springframework.stereotype.Component

@Component
class AddressViewMapper : Mapper<Address, AddressDTO> {

    override fun map(t: Address): AddressDTO {
        return AddressDTO(
            id_address = t.id_address,
            street = t.street,
            address_number = t.address_number,
            neighborhood = t.neighborhood,
            city = t.city,
            states = t.states
        )
    }

}