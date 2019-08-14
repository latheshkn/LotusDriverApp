package com.example.drivercab.CarProfileModel;

public class CarProfire {
    public String id;
    public  String did;
    public String vehicle_no;
    public String vehicle_model;
    public String vehicle_Image;
    public String rcbook_image1;


    public CarProfire(String id, String did, String vehicle_no, String vehicle_model, String vehicle_Image, String rcbook_image1) {
        this.id = id;
        this.did = did;
        this.vehicle_no = vehicle_no;
        this.vehicle_model = vehicle_model;
        this.vehicle_Image = vehicle_Image;
        this.rcbook_image1 = rcbook_image1;
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

    public String getVehicle_no() {
        return vehicle_no;
    }

    public void setVehicle_no(String vehicle_no) {
        this.vehicle_no = vehicle_no;
    }

    public String getVehicle_model() {
        return vehicle_model;
    }

    public void setVehicle_model(String vehicle_model) {
        this.vehicle_model = vehicle_model;
    }

    public String getVehicle_Image() {
        return vehicle_Image;
    }

    public void setVehicle_Image(String vehicle_Image) {
        this.vehicle_Image = vehicle_Image;
    }

    public String getRcbook_image1() {
        return rcbook_image1;
    }

    public void setRcbook_image1(String rcbook_image1) {
        this.rcbook_image1 = rcbook_image1;
    }
}
