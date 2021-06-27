package com.trungtx.poly.Dto;

public class CheckEmail {

    private boolean checkMail;

    public CheckEmail() {
    }

    public CheckEmail(boolean checkMail) {
        this.checkMail = checkMail;
    }

    public boolean isCheckMail() {
        return checkMail;
    }

    public void setCheckMail(boolean checkMail) {
        this.checkMail = checkMail;
    }
}
