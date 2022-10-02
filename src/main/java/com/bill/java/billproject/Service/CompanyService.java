package com.bill.java.billproject.Service;

import com.bill.java.billproject.Model.Company;
import com.bill.java.billproject.Repo.CompanyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepo companyRepo;

    public void saveCompany(Company company){
        companyRepo.save(company);
    }
}
