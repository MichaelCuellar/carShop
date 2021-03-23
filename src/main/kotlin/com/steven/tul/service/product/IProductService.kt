package com.steven.tul.service.product

import com.steven.tul.models.entity.Product
import org.springframework.http.ResponseEntity

interface IProductService {

    fun addProduct(product: Product): ResponseEntity<String>
    fun listProduct(): List<Product>
    fun updateProduct(product: Product): ResponseEntity<String>
    fun deleteProduct(sku: Int): ResponseEntity<String>
}
