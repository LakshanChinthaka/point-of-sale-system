package com.chinthaka.pointofsalesystem.dto.Cutomer.request;

import com.chinthaka.pointofsalesystem.enums.Gender;

public class CustomerUpdateDto {
    private Integer customerID;
    private String customerName;
    private Gender gender;
    private String customerAddress;
    private String nic;
    private String email;
    private String contact;

    public CustomerUpdateDto() {
    }

    public CustomerUpdateDto(Integer customerID, String customerName, Gender gender, String customerAddress, String nic, String email, String contact) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.gender = gender;
        this.customerAddress = customerAddress;
        this.nic = nic;
        this.email = email;
        this.contact = contact;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "CustomerUpdateDto{" +
                "customerID=" + customerID +
                ", customerName='" + customerName + '\'' +
                ", gender=" + gender +
                ", customerAddress='" + customerAddress + '\'' +
                ", nic='" + nic + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
