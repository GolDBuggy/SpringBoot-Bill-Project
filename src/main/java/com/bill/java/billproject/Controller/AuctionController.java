package com.bill.java.billproject.Controller;

import com.bill.java.billproject.Model.Auction;
import com.bill.java.billproject.Service.AuctionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/auction")
@RequiredArgsConstructor
public class AuctionController {

    private final AuctionService auctionService;

    @PostMapping("/create")
    public ResponseEntity<String> createAuction(@RequestBody Auction auction, Principal principal){
        auctionService.saveAuction(auction,principal);
        return ResponseEntity.ok("Auction created successfully!");
    }
}
