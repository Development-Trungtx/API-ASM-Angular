package com.trungtx.poly.ServiceImpl;

import com.trungtx.poly.Dto.ProductDto;
import com.trungtx.poly.Entity.Product;
import com.trungtx.poly.Entity.TypeProduct;
import com.trungtx.poly.Repository.ProductRepository;
import com.trungtx.poly.Repository.TypeProductRepository;
import com.trungtx.poly.Service.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TypeProductRepository typeProductRepository;

    @Override
    public List<ProductDto> fildAllProduct() {
        try {
            List<Product> productList = productRepository.findAll();
            List<ProductDto> productDtos = new ArrayList<>();
            for (Product product : productList) {
                productDtos.add(new ProductDto(product.getProductId(), product.getName(), product.getPrice(), product.getTotal(), product.getSale(),
                        product.getImage(), product.getDescrition(), product.getTypeId().getName()));
            }
            Type listType = new TypeToken<List<ProductDto>>() {
            }.getType();
            List<ProductDto> pr = modelMapper.map(productDtos, listType);
            return pr;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ProductDto insertDepart(ProductDto productDto) {
        try {
            TypeProduct typeProduct = typeProductRepository.findByName(productDto.getNameTypePro());
            Product product = modelMapper.map(new Product(null, productDto.getName(), productDto.getPrice(), productDto.getTotal(), productDto.getSale(),
                    productDto.getImage(), productDto.getDescrition(), typeProduct), Product.class);
            productRepository.save(product);
            return findById(product.getProductId());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ProductDto updateDepart(ProductDto productDto) {
        try {
            TypeProduct typeProduct = typeProductRepository.findByName(productDto.getNameTypePro());
            Product product = modelMapper.map(new Product(productDto.getProductId(), productDto.getName(), productDto.getPrice(), productDto.getTotal(), productDto.getSale(), productDto.getImage(), productDto.getDescrition(), typeProduct), Product.class);
            productRepository.save(product);
            return findById(product.getProductId());
        } catch (Exception e) {
            return null;
        }
    }


    @Override
    public ProductDto findById(int id) {
        try {
            Optional<Product> product = productRepository.findById(id);
            ProductDto productDto = modelMapper.map(new ProductDto(
                    product.get().getProductId(), product.get().getName(), product.get().getPrice(), product.get().getTotal(),
                    product.get().getSale(), product.get().getImage(), product.get().getDescrition(), product.get().getTypeId().getName()
            ), ProductDto.class);
            return productDto;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ProductDto deleteProduct(int id) {
        try {
            ProductDto product = findById(id);
            productRepository.deleteById(id);
            return product;
        }catch (Exception e){
            return null;
        }
    }
}
