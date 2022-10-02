package com.bill.java.billproject.Service;

import com.bill.java.billproject.Model.Member;
import com.bill.java.billproject.Repo.MemberRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberDetailService implements UserDetailsService {

    private final MemberRepo repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member=repo.findByEmail(email).get();
        return new User(member.getEmail(),member.getPassword(), Arrays.asList(member.getRoles().split(",")).stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
    }
}
