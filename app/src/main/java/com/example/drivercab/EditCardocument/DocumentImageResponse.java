package com.example.drivercab.EditCardocument;

public class DocumentImageResponse {

    String status;
    DocumentImage data;

    public DocumentImageResponse(String status, DocumentImage data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DocumentImage getData() {
        return data;
    }

    public void setData(DocumentImage data) {
        this.data = data;
    }
}
