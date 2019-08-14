package com.example.drivercab.DriverBankDetailModel;

public class Bank {

    public String id;
    public String did;
    public String ac_holder_name;
    public String bank_name;
    public String account_number;
    public String passbook_image;
    public String ifsc_code;

    public Bank(String id, String did, String ac_holder_name, String bank_name, String account_number, String passbook_image, String ifsc_code) {
        this.id = id;
        this.did = did;
        this.ac_holder_name = ac_holder_name;
        this.bank_name = bank_name;
        this.account_number = account_number;
        this.passbook_image = passbook_image;
        this.ifsc_code = ifsc_code;
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

    public String getAc_holder_name() {
        return ac_holder_name;
    }

    public void setAc_holder_name(String ac_holder_name) {
        this.ac_holder_name = ac_holder_name;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getPassbook_image() {
        return passbook_image;
    }

    public void setPassbook_image(String passbook_image) {
        this.passbook_image = passbook_image;
    }

    public String getIfsc_code() {
        return ifsc_code;
    }

    public void setIfsc_code(String ifsc_code) {
        this.ifsc_code = ifsc_code;
    }
}
