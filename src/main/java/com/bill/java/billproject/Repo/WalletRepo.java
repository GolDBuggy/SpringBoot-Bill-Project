package com.bill.java.billproject.Repo;

import com.bill.java.billproject.Model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepo extends JpaRepository<Wallet,String> {
}
