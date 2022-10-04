package com.bill.java.billproject.Service;

import com.bill.java.billproject.Model.Auction;
import com.bill.java.billproject.Model.Member;
import com.bill.java.billproject.Model.Wallet;
import com.bill.java.billproject.Repo.AuctionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;
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
        auction.getMember().getWallet().setCash(checkWallet(auction.getMember().getWallet().getCash(),auction.getAmountRequested()));
        auctionRepo.save(auction);
        walletService.update(auction.getMember().getWallet());
    }

    private BigDecimal checkWallet(BigDecimal wallet,BigDecimal request){
        if(!(wallet.compareTo(request)==1))
            throw new RuntimeException("insufficient balance!");

      return wallet.subtract(request);
    }

    public Auction getByIdAndMember(String id, Member member){
        return auctionRepo.findByIdAndInvoice_Member(id,member).get();
    }


    public void update(Auction auction){
        auctionRepo.save(auction);
    }
}
