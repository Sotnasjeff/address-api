package com.addressapi.service

import com.addressapi.dto.AddressDTO
import com.addressapi.dto.AddressUpdateDTO
import com.addressapi.exception.NotFoundException
import com.addressapi.mapper.AddressViewMapper
import com.addressapi.model.Address
import com.addressapi.repository.AddressRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class AddressService(
    private val repository: AddressRepository,
    private val addressViewMapper: AddressViewMapper,
    private val notFoundExceptionMessage: String = "Endereço não encontrado"
) {

    fun listAllAddress(
        street: String?,
        page: Pageable
    ): Page<AddressDTO> {
        val listAddress = repository.findAll(page)


        return listAddress.map { addressViewMapper.map(it) }

    }

    fun createAddress(form: Address): AddressDTO {
        val createAddress = repository.save(form)

        return addressViewMapper.map(createAddress)
    }

    fun updateAddress(form: AddressUpdateDTO): AddressDTO {
        val updateAddress = repository.findById(form.id).orElseThrow { NotFoundException(notFoundExceptionMessage) }
        updateAddress.street = form.street
        updateAddress.neighborhood = form.neighborhood
        updateAddress.address_number = form.address_number
        updateAddress.city = form.city

        return addressViewMapper.map(updateAddress)
    }

    fun deletar(id: Int) {
        repository.deleteById(id)
    }

}