package com.trungtx.poly.Dto;

import java.sql.Date;

public class UserTableDto {

    private Integer userId;
    private String userName;
    private String passWord;
    private String roles;
    private String nameCustomer;
    private int age;
    private String address;
    private Date birthday;
    private String numberPhone;
    private String email;
    private String imges;

    public UserTableDto(Integer userId, String userName, String passWord, String roles, String nameCustomer, int age, String address, Date birthday, String numberPhone, String email, String imges) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.roles = roles;
        this.nameCustomer = nameCustomer;
        this.age = age;
        this.address = address;
        this.birthday = birthday;
        this.numberPhone = numberPhone;
        this.email = email;
        this.imges = imges;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImges() {
        return imges;
    }

    public void setImges(String imges) {
        this.imges = imges;
    }
}
