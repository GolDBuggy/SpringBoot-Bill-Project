package com.bill.java.billproject.Controller;

import com.bill.java.billproject.Model.Wallet;
import com.bill.java.billproject.Service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/wallet")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    @PostMapping("/create")
    public ResponseEntity<String> createWallet(Principal principal){
        walletService.createWallet(new Wallet(),principal);
        return ResponseEntity.ok("Wallet created!");
    }

}
