package com.bill.java.billproject.Repo;

import com.bill.java.billproject.Model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepo extends JpaRepository<Invoice,String> {

    List<Invoice> findAllByMember_Email(String email);
}
