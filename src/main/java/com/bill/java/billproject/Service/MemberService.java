package com.bill.java.billproject.Service;

import com.bill.java.billproject.Dto.RegisterDto;
import com.bill.java.billproject.Model.Company;
import com.bill.java.billproject.Model.Member;
import com.bill.java.billproject.Repo.MemberRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepo memberRepo;
    private final CompanyService companyService;
    private final BCryptPasswordEncoder encoder;
    private final ModelMapper mapper;


    private static String DEFAULT_ROLE="ROLE_MEMBER";

    public RegisterDto save(RegisterDto registerDto){
        checkPass(registerDto);
        Member member=confMember(mapper.map(registerDto,Member.class));
        companyService.saveCompany(member.getCompany());
        memberRepo.save(member);

        return registerDto;
    }


    private void checkPass(RegisterDto registerDto){
        if (!registerDto.getPassword().equals(registerDto.getRePass()))
            throw new RuntimeException("Password must be equals!");
    }

    private Member confMember(Member member){
        member.setPassword(encoder.encode(member.getPassword()));
        member.setRoles(DEFAULT_ROLE);
        member.setRegisterDate(new Date());
        return member;
    }




}
