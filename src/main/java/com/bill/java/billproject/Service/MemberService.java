package com.bill.java.billproject.Service;

import com.bill.java.billproject.Model.Member;
import com.bill.java.billproject.Repo.MemberRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepo memberRepo;
    private final BCryptPasswordEncoder encoder;

    private static String DEFAULT_ROLE="ROLE_MEMBER";

    public void save(Member member){
        member.setPassword(encoder.encode(member.getPassword()));
        member.setRoles(DEFAULT_ROLE);
        member.setRegisterDate(new Date());
        memberRepo.save(member);
    }


}
