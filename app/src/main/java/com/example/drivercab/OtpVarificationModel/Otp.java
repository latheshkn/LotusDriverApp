package com.example.drivercab.OtpVarificationModel;

public class Otp {

    public String status;
    public String mobile;
    public String otp;
    public String id;
    public  String did;
    public String data;


    public Otp(String status, String mobile, String otp, String id, String did, String data) {
        this.status = status;
        this.mobile = mobile;
        this.otp = otp;
        this.id = id;
        this.did = did;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
