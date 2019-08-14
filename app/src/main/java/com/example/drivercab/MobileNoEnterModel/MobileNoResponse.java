package com.example.drivercab.MobileNoEnterModel;

public class MobileNoResponse {

     String status;
     String id;
     String data;
     String mobile;

    public MobileNoResponse(String status, String id, String data, String mobile) {
        this.status = status;
        this.id = id;
        this.data = data;
        this.mobile = mobile;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
