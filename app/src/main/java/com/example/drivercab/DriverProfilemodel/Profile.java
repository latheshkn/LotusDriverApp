package com.example.drivercab.DriverProfilemodel;

public class Profile {

    public String id;
    public String name;
    public String mobile;
    public String driver_image;

    public Profile(String id, String name, String mobile, String driverImage) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.driver_image = driverImage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getdriver_image() {
        return driver_image;
    }

    public void setdriver_imagee(String driverImage) {
        this.driver_image = driverImage;
    }
}
