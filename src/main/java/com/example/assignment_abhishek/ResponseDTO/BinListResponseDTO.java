package com.example.assignment_abhishek.ResponseDTO;

import java.io.Serializable;

public class BinListResponseDTO implements Serializable{

     private static final long serialVersionUID = 12342342355234223L;

     private NumberDTO numberDTO;

     private String scheme;

     private String type;

     private String brand;



    private Boolean prepaid;

     private CountryDTO countryDTO;

     private BankDTO bankDTO;


    public NumberDTO getNumber() {
        return numberDTO;
    }

    public void setNumber(NumberDTO numberDTO) {
        this.numberDTO = numberDTO;
    }

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Boolean getPrepaid() {
        return prepaid;
    }

    public void setPrepaid(Boolean prepaid) {
        this.prepaid = prepaid;
    }

    public CountryDTO getCountry() {
        return countryDTO;
    }

    public void setCountry(CountryDTO countryDTO) {
        this.countryDTO = countryDTO;
    }

    public BankDTO getBank() {
        return bankDTO;
    }

    public void setBank(BankDTO bankDTO) {
        this.bankDTO = bankDTO;
    }

    @Override
    public String toString() {
        return "BinListResponseDTO{" +
                "numberDTO=" + numberDTO +
                ", scheme='" + scheme + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", prepaid=" + prepaid +
                ", countryDTO=" + countryDTO +
                ", bankDTO=" + bankDTO +
                '}';
    }


}
