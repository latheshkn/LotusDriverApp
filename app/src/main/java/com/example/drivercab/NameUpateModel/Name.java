package com.example.drivercab.NameUpateModel;

public class Name {

    public Integer mobile;
    public String name;

    public Name(Integer mobile, String name) {
        this.mobile = mobile;
        this.name = name;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
