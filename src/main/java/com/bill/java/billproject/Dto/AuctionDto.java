package com.bill.java.billproject.Dto;

import com.bill.java.billproject.Model.Invoice;
import com.bill.java.billproject.Model.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuctionDto {

    private String id;
    private BigDecimal amountRequested;
    private boolean status;
    private MemberDto member;
}
