package com.example.assignment_abhishek.ResponseDTO;

import java.io.Serializable;

public class CardDetailsPayloadDTO implements Serializable {

    private static final long serialVersionUID = 2342353454356233L;

    private String scheme;

    private String type;

    private String bank;

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
}
