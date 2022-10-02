package com.bill.java.billproject.Repo;

import com.bill.java.billproject.Model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepo extends JpaRepository<Member,String> {

  Optional<Member> findByEmail(String email);

}
