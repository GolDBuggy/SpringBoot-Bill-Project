package com.bill.java.billproject.Controller;

import com.bill.java.billproject.Dto.LoginDto;
import com.bill.java.billproject.Dto.RegisterDto;
import com.bill.java.billproject.Model.Member;
import com.bill.java.billproject.Service.JwtService;
import com.bill.java.billproject.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping("/save")
    public ResponseEntity<RegisterDto> save(@RequestBody RegisterDto registerDto){
        return ResponseEntity.ok(memberService.save(registerDto));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword()));

        return ResponseEntity.ok(jwtService.generateToken(loginDto.getEmail()));
    }

    @GetMapping("/")
    public ResponseEntity<String> home(){
        return ResponseEntity.ok("Welcome Bill System!");
    }

}
