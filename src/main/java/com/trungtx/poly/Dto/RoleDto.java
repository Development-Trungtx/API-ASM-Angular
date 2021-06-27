package com.trungtx.poly.Dto;

public class RoleDto {

    private String role;
    private String nameCus;
    private String imgesCus;

    public RoleDto() {
    }

    public RoleDto(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNameCus() {
        return nameCus;
    }

    public void setNameCus(String nameCus) {
        this.nameCus = nameCus;
    }

    public String getImgesCus() {
        return imgesCus;
    }

    public void setImgesCus(String imgesCus) {
        this.imgesCus = imgesCus;
    }
}
