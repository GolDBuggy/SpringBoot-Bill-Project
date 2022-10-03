package com.bill.java.billproject.Repo;

import com.bill.java.billproject.Model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepo extends JpaRepository<Invoice,String> {
}
