package com.bill.java.billproject.Dto;

import com.bill.java.billproject.Model.Auction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {

    private String id;
    private BigDecimal invoiceAmount;
    private List<AuctionDto> auctions;
}
