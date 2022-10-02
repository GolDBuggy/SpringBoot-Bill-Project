package com.bill.java.billproject.Service;

import com.bill.java.billproject.Model.Wallet;
import com.bill.java.billproject.Repo.WalletRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Principal;

@Service
@RequiredArgsConstructor
public class WalletService {

    private final WalletRepo walletRepo;
    private final MemberService memberService;


    public void createWallet(Wallet wallet, Principal principal){
        wallet.setCash(BigDecimal.valueOf(0));
        wallet.setMember(memberService.getByMail(principal.getName()));
        walletRepo.save(wallet);
    }

}
