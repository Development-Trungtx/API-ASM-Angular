package com.trungtx.poly.Controller;

import com.trungtx.poly.Dto.ProductDto;
import com.trungtx.poly.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    //    produces = "application/json"
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/product", produces = "application/json")
    public List<ProductDto> getAll() {
        return productService.fildAllProduct();
    }

    @GetMapping(value = "/product/{id}", produces = "application/json")
    public ProductDto getById(@PathVariable int id) {
        return productService.findById(id);
    }

    @PostMapping("/product")
    public ProductDto save(@RequestBody ProductDto productDto) {
        return productService.insertDepart(productDto);
    }

    @PutMapping("/product/{id}")
    public ProductDto update(@RequestBody ProductDto productDto, @PathVariable int id) {
        productDto.setProductId(id);
        return productService.updateDepart(productDto);
    }

    @DeleteMapping("/product/{id}")
    public ProductDto delete(@PathVariable int id) {
        return productService.deleteProduct(id);
    }
}
