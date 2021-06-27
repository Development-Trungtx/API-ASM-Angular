package com.trungtx.poly.Service;

import com.trungtx.poly.Dto.ProductDto;

import java.util.List;

public interface ProductService {

    public List<ProductDto> fildAllProduct();

    public ProductDto insertDepart(ProductDto product);

    public ProductDto updateDepart(ProductDto product);

    public ProductDto findById(int id);

    public ProductDto deleteProduct(int id);
}
