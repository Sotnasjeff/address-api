package com.addressapi.mapper

interface Mapper<T, U> {

    fun map(t: T): U
}