package com.bill.java.billproject.Service;

import com.bill.java.billproject.Model.Auction;
import com.bill.java.billproject.Model.Member;
import com.bill.java.billproject.Repo.AuctionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class AuctionService {

    private final AuctionRepo auctionRepo;
    private final MemberService memberService;


    public void saveAuction(Auction auction, Principal principal){
        auction.setMember(memberService.getByMail(principal.getName()));
        auction.setStatus(false);
        auctionRepo.save(auction);
    }


    public Auction getByIdAndMember(String id, Member member){
        return auctionRepo.findByIdAndInvoice_Member(id,member).get();
    }


    public void update(Auction auction){
        auctionRepo.save(auction);
    }
}
