package com.bill.java.billproject.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "company_information")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID")
    @Column(name = "company_id")
    private String id;

    @Column(name = "company_title")
    private String title;

    @Column(name = "sector")
    private String sector;

    @Column(name = "tax_id")
    private String taxId;

    @Column(name = "province")
    private String province;

    @Column(name = "district")
    private String district;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @OneToOne(mappedBy = "company")
    private Member member;


}
