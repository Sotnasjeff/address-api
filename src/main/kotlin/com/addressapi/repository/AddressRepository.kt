package com.addressapi.repository

import com.addressapi.model.Address
import org.springframework.data.jpa.repository.JpaRepository

interface AddressRepository : JpaRepository<Address, Int> {

}