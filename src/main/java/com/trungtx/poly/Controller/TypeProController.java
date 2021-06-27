package com.trungtx.poly.Controller;

import com.trungtx.poly.Dto.TypeProDto;
import com.trungtx.poly.Service.TypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TypeProController {
    //    , produces = "application/json"
    @Autowired
    private TypeProductService typeProductService;

    @GetMapping(value = "/typeProduct")
    public List<TypeProDto> getAll() {
        return typeProductService.fildAllTypePro();
    }

    @GetMapping(value = "/typeProduct/{id}")
    public TypeProDto getById(@PathVariable int id) {
        return typeProductService.findById(id);
    }

    @PostMapping("/typeProduct")
    public TypeProDto save(@RequestBody TypeProDto typeProDto) {
        return typeProductService.insertTypePro(typeProDto);
    }

    @PutMapping("/typeProduct/{id}")
    public TypeProDto update(@RequestBody TypeProDto typeProDto, @PathVariable int id) {
        typeProDto.setTypeId(id);
        return typeProductService.updateTypePro(typeProDto);
    }

    @DeleteMapping("/typeProduct/{id}")
    public TypeProDto delete(@PathVariable int id) {
        return typeProductService.deleteTypePro(id);
    }
}
