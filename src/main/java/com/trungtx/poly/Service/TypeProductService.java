package com.trungtx.poly.Service;

import com.trungtx.poly.Dto.TypeProDto;
import com.trungtx.poly.Entity.Product;

import java.util.List;

public interface TypeProductService {

    public List<TypeProDto> fildAllTypePro();

    public TypeProDto insertTypePro(TypeProDto typeProDto);

    public TypeProDto updateTypePro(TypeProDto typeProDto);

    public TypeProDto findById(int id);

    public TypeProDto deleteTypePro(int id);
}
