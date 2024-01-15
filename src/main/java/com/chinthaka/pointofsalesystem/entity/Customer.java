package com.chinthaka.pointofsalesystem.entity;

import com.chinthaka.pointofsalesystem.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id", length = 30)
    private Integer customerID;

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

}
