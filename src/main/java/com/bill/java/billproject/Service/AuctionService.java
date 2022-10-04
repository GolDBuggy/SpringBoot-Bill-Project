package com.bill.java.billproject.Service;

import com.bill.java.billproject.Model.Auction;
import com.bill.java.billproject.Model.Member;
import com.bill.java.billproject.Model.Wallet;
import com.bill.java.billproject.Repo.AuctionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class AuctionService {

    private final AuctionRepo auctionRepo;
    private final MemberService memberService;
    private final WalletService walletService;


    public void saveAuction(Auction auction, Principal principal){
        auction.setMember(memberService.getByMail(principal.getName()));
        auction.setStatus(false);
        Wallet wallet=auction.getMember().getWallets().stream().filter(e->e.getCash().compareTo(auction.getAmountRequested())==1).
                findFirst().orElseThrow(()->new RuntimeException("insufficient balance!"));
        wallet.setCash(wallet.getCash().subtract(auction.getAmountRequested()));
        auctionRepo.save(auction);
        walletService.update(wallet);
    }



    public Auction getByIdAndMember(String id, Member member){
        return auctionRepo.findByIdAndInvoice_Member(id,member).get();
    }


    public void update(Auction auction){
        auctionRepo.save(auction);
    }
}
