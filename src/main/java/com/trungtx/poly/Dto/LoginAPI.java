package com.trungtx.poly.Dto;

public class LoginAPI {

    private String userN;
    private String passW;

    public LoginAPI() {
    }

    public LoginAPI(String userN, String passW) {
        this.userN = userN;
        this.passW = passW;
    }

    public String getUserN() {
        return userN;
    }

    public void setUserN(String userN) {
        this.userN = userN;
    }

    public String getPassW() {
        return passW;
    }

    public void setPassW(String passW) {
        this.passW = passW;
    }
}
