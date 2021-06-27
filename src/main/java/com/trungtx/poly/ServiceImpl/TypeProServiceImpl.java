package com.trungtx.poly.ServiceImpl;

import com.trungtx.poly.Dto.TypeProDto;
import com.trungtx.poly.Entity.Product;
import com.trungtx.poly.Entity.TypeProduct;
import com.trungtx.poly.Repository.ProductRepository;
import com.trungtx.poly.Repository.TypeProductRepository;
import com.trungtx.poly.Service.TypeProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TypeProServiceImpl implements TypeProductService {

    @Autowired
    private TypeProductRepository typeProductRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TypeProDto> fildAllTypePro() {
        try {
            List<TypeProduct> typeProducts = typeProductRepository.findAll();
            List<TypeProDto> typeProDtos = new ArrayList<>();

            for (TypeProduct product : typeProducts) {
                typeProDtos.add(new TypeProDto(product.getTypeId(), product.getName()));
            }
            Type listType = new TypeToken<List<TypeProDto>>() {
            }.getType();
            List<TypeProDto> pr = modelMapper.map(typeProDtos, listType);
            return pr;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public TypeProDto insertTypePro(TypeProDto typeProDto) {
        try {
            TypeProduct product = modelMapper.map(new TypeProduct(null, typeProDto.getName()), TypeProduct.class);
            typeProductRepository.save(product);
            return findById(product.getTypeId());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public TypeProDto updateTypePro(TypeProDto typeProDto) {
        try {
            List<Product> productList = productRepository.findAllByTypeId(typeProDto.getTypeId());
            TypeProduct product = modelMapper.map(new TypeProduct(typeProDto.getTypeId(), typeProDto.getName(), productList), TypeProduct.class);
            typeProductRepository.save(product);
            return findById(product.getTypeId());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public TypeProDto findById(int id) {
        try {
            Optional<TypeProduct> product = typeProductRepository.findById(id);
            TypeProDto typeProDto = modelMapper.map(new TypeProDto(product.get().getTypeId(), product.get().getName()), TypeProDto.class);
            return typeProDto;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public TypeProDto deleteTypePro(int id) {
        try {
            TypeProDto product = findById(id);
            typeProductRepository.deleteById(id);
            return product;
        } catch (Exception e) {
            return null;
        }
    }


}
