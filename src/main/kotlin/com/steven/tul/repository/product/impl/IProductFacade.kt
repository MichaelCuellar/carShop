package com.steven.tul.repository.product.impl

import com.steven.tul.models.entity.Product
import java.util.*

interface IProductFacade {

    fun addProduct(product: Product): Product
    fun listProduct(): List<Product>
    fun existsProduct(sku: Int): Boolean
    fun findProductBySku(sku: Int): Optional<Product>
    fun deleteProduct(id:UUID)
}
