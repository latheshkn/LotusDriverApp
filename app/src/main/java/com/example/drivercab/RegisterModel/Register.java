package com.example.drivercab.RegisterModel;

public class Register {

    public String name;
    public String mobile;
    public String password;
    public String address;
    public String dl_image;
    public String driver_image;
    public String address_image;

    public Register(String name, String mobile, String password, String address, String dl_image, String driver_image) {
        this.name = name;
        this.mobile = mobile;
        this.password = password;
        this.address = address;
        this.dl_image = dl_image;
        this.driver_image = driver_image;
        this.address_image = address_image;
    }

    public Register(String status, Register data) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDl_image() {
        return dl_image;
    }

    public void setDl_image(String dl_image) {
        this.dl_image = dl_image;
    }

    public String getDriver_image() {
        return driver_image;
    }

    public void setDriver_image(String driver_image) {
        this.driver_image = driver_image;
    }

    public String getAddress_image() {
        return address_image;
    }

    public void setAddress_image(String address_image) {
        this.address_image = address_image;
    }
}
