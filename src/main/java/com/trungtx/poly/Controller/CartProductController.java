package com.trungtx.poly.Controller;

import com.trungtx.poly.Dto.CartProductDto;
import com.trungtx.poly.Service.CartProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartProductController {

    @Autowired
    private CartProService cartProService;

    @GetMapping(value = "/cartProduct", produces = "application/json")
    public List<CartProductDto> getAll() {
        return cartProService.fildAllCartProduct();
    }

    @GetMapping(value = "/cartProduct/{id}", produces = "application/json")
    public CartProductDto getById(@PathVariable int id) {
        return cartProService.findCartProById(id);
    }

    @GetMapping(value = "/cartOrderPro/{id}")
    public List<CartProductDto> getAllCartByOrder(@PathVariable int id) {
        return cartProService.findCartByOrderName(id);
    }

    @PostMapping("/cartProduct/{nameOrder}")
    public List<CartProductDto> save(@RequestBody List<CartProductDto> cartProductDto, @PathVariable String nameOrder) {
        return cartProService.insertCartProduct(cartProductDto, nameOrder);
    }

    @PutMapping("/cartProduct/{id}")
    public CartProductDto update(@RequestBody CartProductDto cartProductDto, @PathVariable int id) {
        cartProductDto.setCardProductId(id);
        return cartProService.updateCartProduct(cartProductDto);
    }

    @DeleteMapping("/cartProduct/{id}")
    public CartProductDto delete(@PathVariable int id) {
        return cartProService.deleteCartProduct(id);
    }
}
