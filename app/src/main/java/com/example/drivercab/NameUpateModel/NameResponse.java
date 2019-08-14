package com.example.drivercab.NameUpateModel;

public class NameResponse {

    public String status;
    public Name data;

    public NameResponse(String status, Name data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Name getData() {
        return data;
    }

    public void setData(Name data) {
        this.data = data;
    }
}
