package com.bill.java.billproject.Repo;

import com.bill.java.billproject.Model.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionRepo extends JpaRepository<Auction,String> {
}
