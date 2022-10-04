package com.bill.java.billproject.Service;

import com.bill.java.billproject.Dto.InvoiceDto;
import com.bill.java.billproject.Model.Auction;
import com.bill.java.billproject.Model.Invoice;
import com.bill.java.billproject.Model.Wallet;
import com.bill.java.billproject.Repo.InvoiceRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepo invoiceRepo;
    private final MemberService memberService;
    private final AuctionService auctionService;
    private final ModelMapper mapper;



    public void saveInvoice(Invoice invoice, Principal principal){
        invoice.setMember(memberService.getByMail(principal.getName()));
        invoiceRepo.save(invoice);
    }

    public void updateInvoice(Invoice invoice){
        invoiceRepo.save(invoice);
    }


    public List<InvoiceDto> getAuction(Principal principal){
        return invoiceRepo.findAllByMember_Email(principal.getName()).stream().map(e->mapper.map(e,InvoiceDto.class)).collect(Collectors.toList());
    }

    public void confirm(String auctionId, Principal principal) {
        Auction auction=auctionService.getByIdAndMember(auctionId,memberService.getByMail(principal.getName()));
        Invoice invoice=auction.getInvoice();
        invoice.setInvoiceAmount(invoice.getInvoiceAmount().subtract(auction.getAmountRequested()));
        auction.setStatus(true);
        auctionService.update(auction);
        updateInvoice(invoice);
    }


}
