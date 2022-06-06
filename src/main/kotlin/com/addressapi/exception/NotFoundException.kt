package com.addressapi.exception

import java.lang.RuntimeException

class NotFoundException(message: String?) : RuntimeException(message) {
}