package com.steven.tul.web.api.rest

import com.steven.tul.models.entity.Product
import com.steven.tul.service.product.IProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = ["*"])
class ProductAPI {

    @Autowired
    lateinit var iProductService: IProductService

    @PostMapping("/product")
    fun addProduct(@RequestBody product: Product): ResponseEntity<String>{
        return iProductService.addProduct(product)
    }

    @GetMapping("/")
    fun listProduct(): List<Product> {
        return iProductService.listProduct()
    }

    @PutMapping("/product")
    fun updateProduct(@RequestBody product: Product): ResponseEntity<String>{
        return iProductService.updateProduct(product)
    }

    @DeleteMapping("/product/{sku}")
    fun deleteProduct(@PathVariable sku: Int): ResponseEntity<String>{
        return iProductService.deleteProduct(sku)
    }

}
