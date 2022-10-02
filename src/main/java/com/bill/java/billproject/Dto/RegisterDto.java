package com.bill.java.billproject.Dto;

import com.bill.java.billproject.Model.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {

    private String firstName;
    private String lastName;
    private String email;
    private String companyPosition;
    private String password;
    private String rePass;
    private String phone;
    private CompanyDto company;
}
