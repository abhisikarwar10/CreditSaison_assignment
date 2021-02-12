package com.example.assignment_abhishek.ResponseDTO;

import java.io.Serializable;

public class NumberDTO implements Serializable {

    private static final long serialVersionUID = 2452345235526256L;

    private int length;

    private boolean luhn;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isLuhn() {
        return luhn;
    }

    public void setLuhn(boolean luhn) {
        this.luhn = luhn;
    }
}