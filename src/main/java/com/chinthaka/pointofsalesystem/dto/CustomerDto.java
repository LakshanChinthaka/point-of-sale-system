package com.chinthaka.pointofsalesystem.dto;

import com.chinthaka.pointofsalesystem.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto {
    private Integer customerID;
    private String customerName;
    private Gender gender;
    private String customerAddress;
    private String nic;
    private String email;
    private String contactNo;
    private boolean activeStatus;
}
