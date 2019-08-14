package com.example.drivercab.DriverBankDetailModel;

import java.util.List;

public class BankResponse {

    private String status;
    private List<Bank> data = null;

    public BankResponse(String status, List<Bank> data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Bank> getData() {
        return data;
    }

    public void setData(List<Bank> data) {
        this.data = data;
    }
}
