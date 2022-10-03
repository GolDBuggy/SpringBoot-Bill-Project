package com.bill.java.billproject.Repo;

import com.bill.java.billproject.Model.Auction;
import com.bill.java.billproject.Model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuctionRepo extends JpaRepository<Auction,String> {

    Optional<Auction> findByIdAndInvoice_Member(String id, Member member);
}
