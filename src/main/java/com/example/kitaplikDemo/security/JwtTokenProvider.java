package com.example.kitaplikDemo.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenProvider {

    @Value("${kitaplik.app.secret}")
    private String APP_SECRET;

    @Value("${kitaplik.app.expires.in}")
    private Long EXPIRES_IN;

    public String generateJwtToken(Authentication authentication) {
        JwtUserDetails jwtUserDetails = (JwtUserDetails) authentication.getPrincipal();
        Date expireDate = new Date(new Date().getTime() + EXPIRES_IN);

        return Jwts.builder().setSubject(Long.toString(jwtUserDetails.getId()))
                .setIssuedAt(new Date()).setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, APP_SECRET).compact();

    }

    Long getUserIdFromJwt(String token) {
        Claims claims = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token).getBody();

        return Long.parseLong(claims.getSubject());
    }

    boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
            return !isTokenExpired(token);
        } catch (SignatureException e) { //geçerliliğini kontrol etmek için
            return false;
        } catch (MalformedJwtException e) { //beklenen formata uymadığı durumlarda
            return false;
        } catch (ExpiredJwtException e) { //geçerlilik süresi
            return false;
        } catch (UnsupportedJwtException e) { //belirli algoritmayı desteklemiyorsa
            return false;
        } catch (IllegalArgumentException e) { //geçersiz veya yanlış yöntem
            return false;
        }
    }

    private boolean isTokenExpired(String token) {
        Date expiration = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token).getBody().getExpiration();
        return expiration.before(new Date());
    }

}