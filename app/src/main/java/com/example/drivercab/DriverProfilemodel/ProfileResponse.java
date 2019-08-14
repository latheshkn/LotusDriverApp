package com.example.drivercab.DriverProfilemodel;

import java.util.List;

public class ProfileResponse {
    public String status;
    public List<Profile> data = null;

    public ProfileResponse(String status, List<Profile> data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Profile> getData() {
        return data;
    }

    public void setData(List<Profile> data) {
        this.data = data;
    }
}
