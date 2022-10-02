package com.bill.java.billproject.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {

    private String title;
    private String sector;
    private String taxId;
    private String province;
    private String district;
    private String address;
    private String phone;
}
