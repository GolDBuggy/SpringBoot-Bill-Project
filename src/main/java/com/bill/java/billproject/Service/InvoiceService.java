package com.bill.java.billproject.Service;

import com.bill.java.billproject.Model.Invoice;
import com.bill.java.billproject.Repo.InvoiceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepo invoiceRepo;
    private final MemberService memberService;



    public void saveInvoice(Invoice invoice, Principal principal){
        invoice.setMember(memberService.getByMail(principal.getName()));
        invoiceRepo.save(invoice);
    }
}
