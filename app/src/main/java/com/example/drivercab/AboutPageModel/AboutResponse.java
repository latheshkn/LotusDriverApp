package com.example.drivercab.AboutPageModel;

import java.util.ArrayList;
import java.util.List;

public class AboutResponse {

    String status ;
    List<About> data=new ArrayList<>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<About> getData() {
        return data;
    }

    public void setData(List<About> data) {
        this.data = data;
    }
}
