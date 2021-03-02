package com.rtsoftworld.retrofitgetpost.Model;

import com.google.gson.annotations.SerializedName;

public class MyDataModel {
    @SerializedName("ip")
    private String ip;
    @SerializedName("ip_decimal")
    private Integer ipDecimal;
    @SerializedName("country")
    private String country;
    @SerializedName("country_iso")
    private String countryIso;
    @SerializedName("city")
    private String city;


    public MyDataModel() {
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getIpDecimal() {
        return ipDecimal;
    }

    public void setIpDecimal(Integer ipDecimal) {
        this.ipDecimal = ipDecimal;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryIso() {
        return countryIso;
    }

    public void setCountryIso(String countryIso) {
        this.countryIso = countryIso;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
