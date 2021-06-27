package com.trungtx.poly.Dto;

public class TypeProDto {

    private Integer typeId;
    private String name;

    public TypeProDto(Integer typeId, String name) {
        this.typeId = typeId;
        this.name = name;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
