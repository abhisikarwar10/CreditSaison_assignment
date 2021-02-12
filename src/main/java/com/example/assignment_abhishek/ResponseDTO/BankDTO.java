package com.example.assignment_abhishek.ResponseDTO;

import java.io.Serializable;

public class BankDTO implements Serializable {

    private static final long serialVersionUID = 523423514252345635L;

    private String name;

    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}