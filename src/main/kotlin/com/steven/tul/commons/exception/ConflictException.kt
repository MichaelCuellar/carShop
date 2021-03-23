package com.steven.tul.commons.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.CONFLICT)
class ConflictException (sku: Int?) : RuntimeException("Ya existe el producto con el codigo sku $sku")
