package com.bill.java.billproject.Controller;

import com.bill.java.billproject.Dto.InvoiceDto;
import com.bill.java.billproject.Model.Invoice;
import com.bill.java.billproject.Service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/invoice")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;

    @PostMapping("/create")
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice, Principal principal){
        invoiceService.saveInvoice(invoice,principal);
        return ResponseEntity.ok(invoice);
    }

    @GetMapping("/all")
    public ResponseEntity<List<InvoiceDto>> getAll(Principal principal){
        return ResponseEntity.ok(invoiceService.getAuction(principal));
    }

    @GetMapping("/confirm/{auctionId}")
    public ResponseEntity<String> confirm(@PathVariable String auctionId,Principal principal){
        invoiceService.confirm(auctionId,principal);
    return ResponseEntity.ok("Updated!");
    }


}
