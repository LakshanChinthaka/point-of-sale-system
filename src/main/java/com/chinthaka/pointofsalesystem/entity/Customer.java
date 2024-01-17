package com.chinthaka.pointofsalesystem.entity;

import com.chinthaka.pointofsalesystem.enums.Gender;


import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id", length = 30)
    private Integer  customerID;

    @Column(name = "customer_name", length = 100, nullable = false)
    private String customerName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "customer_address", length = 200)
    private String customerAddress;

    @Column(name = "nic", unique = true)
    private String nic;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "contact_no", nullable = false, length = 12)
    private String contactNo;

    @Column(name = "active_status", columnDefinition = "TINYINT default 1")
    private boolean activeStatus;

    @OneToMany(mappedBy="customers")
    private Set<Order> purchaseOrders;

    public Customer() {
    }

    public Customer(Integer customerID, String customerName, Gender gender, String customerAddress, String nic, String email, String contactNo, boolean activeStatus, Set<Order> purchaseOrders) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.gender = gender;
        this.customerAddress = customerAddress;
        this.nic = nic;
        this.email = email;
        this.contactNo = contactNo;
        this.activeStatus = activeStatus;
        this.purchaseOrders = purchaseOrders;
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

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public Set<Order> getPurchaseOrders() {
        return purchaseOrders;
    }

    public void setPurchaseOrders(Set<Order> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", customerName='" + customerName + '\'' +
                ", gender=" + gender +
                ", customerAddress='" + customerAddress + '\'' +
                ", nic='" + nic + '\'' +
                ", email='" + email + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", activeStatus=" + activeStatus +
                ", purchaseOrders=" + purchaseOrders +
                '}';
    }
}
