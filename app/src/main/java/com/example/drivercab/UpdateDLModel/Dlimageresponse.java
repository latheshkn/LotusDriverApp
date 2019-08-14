package com.example.drivercab.UpdateDLModel;

public class Dlimageresponse {

    public String status;
    public Dlimage data;

    public Dlimageresponse(String status, Dlimage data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Dlimage getData() {
        return data;
    }

    public void setData(Dlimage data) {
        this.data = data;
    }
}
