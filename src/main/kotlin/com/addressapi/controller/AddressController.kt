package com.addressapi.controller

import com.addressapi.dto.AddressDTO
import com.addressapi.dto.AddressUpdateDTO
import com.addressapi.model.Address
import com.addressapi.service.AddressService
import javax.transaction.Transactional
import org.springframework.cache.annotation.CacheEvict
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/address")
class AddressController(
    private val addressService: AddressService
) {

    @GetMapping
    fun listAllAddress(
        @RequestParam(required = false) street: String?,
        @PageableDefault(size = 5) page: Pageable
    ): Page<AddressDTO> {
        return addressService.listAllAddress(street, page)
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = ["address"], allEntries = true)
    fun createAddress(
        @RequestBody form: Address,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<AddressDTO>{
        val addressView = addressService.createAddress(form)
        val uri = uriBuilder.path("/address/${addressView.id_address}").build().toUri()
        return ResponseEntity.created(uri).body(addressView)
    }

    @PutMapping
    @Transactional
    @CacheEvict(value = ["address"], allEntries = true)
    fun updateAddress(
        @RequestBody form: AddressUpdateDTO
    ): ResponseEntity<AddressDTO>{
        val addressView = addressService.updateAddress(form)
        return ResponseEntity.ok(addressView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    @CacheEvict(value = ["address"], allEntries = true)
    fun deleteAddress(@PathVariable id: Int){
        addressService.deletar(id)
    }


}