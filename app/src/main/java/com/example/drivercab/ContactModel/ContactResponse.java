package com.example.drivercab.ContactModel;

public class ContactResponse {
    public String status;
    public Contact data;

    public ContactResponse(String status, Contact data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Contact getData() {
        return data;
    }

    public void setData(Contact data) {
        this.data = data;
    }
}
