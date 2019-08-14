package com.example.drivercab.CarProfileModel;

import java.util.ArrayList;
import java.util.List;

public class CarProfileResponse {
    public String status;
    public List<CarProfire> data = new ArrayList<>();

    public CarProfileResponse(String status, List<CarProfire> data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<CarProfire> getData() {
        return data;
    }

    public void setData(List<CarProfire> data) {
        this.data = data;
    }
}
