package com.example.drivercab.EditCardocument;

public class DocumentImage {


    private Integer id;
    private Object rcbook_image1;

    public DocumentImage(Integer id, Object rcbook_image1) {
        this.id = id;
        this.rcbook_image1 = rcbook_image1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getRcbook_image1() {
        return rcbook_image1;
    }

    public void setRcbook_image1(Object rcbook_image1) {
        this.rcbook_image1 = rcbook_image1;
    }
}
