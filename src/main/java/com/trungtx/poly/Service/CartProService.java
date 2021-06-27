package com.trungtx.poly.Service;

import com.trungtx.poly.Dto.CartProductDto;

import java.util.List;

public interface CartProService {

    public List<CartProductDto> fildAllCartProduct();

    public List<CartProductDto> insertCartProduct(List<CartProductDto> cartProductDto, String userName);

    public CartProductDto updateCartProduct(CartProductDto cartProductDto);

    public CartProductDto findCartProById(int id);

    public List<CartProductDto> findCartByOrderName(int nameCart);

    public CartProductDto deleteCartProduct(int id);

}
