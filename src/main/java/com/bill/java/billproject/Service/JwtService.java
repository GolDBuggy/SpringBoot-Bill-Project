package com.bill.java.billproject.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    private static String SECRET_KEY="IBRAHIM";

    public String generateToken(String email){
        return Jwts.builder().setSubject(email).setIssuer("ibrahim").
                setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+10*60*1000)).
                signWith(SignatureAlgorithm.HS256,SECRET_KEY).compact();
    }


    public boolean validateToken(String token){
        if (getMemberByToken(token)!=null&&isExpired(token)){
            return true;
        }
        return false;
    }

    public String getMemberByToken(String token){
        Claims claims=getClaims(token);
        return claims.getSubject();
    }

    private boolean isExpired(String token){
        Claims claims=getClaims(token);
        return claims.getExpiration().after(new Date(System.currentTimeMillis()));
    }


    private Claims getClaims(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
}
