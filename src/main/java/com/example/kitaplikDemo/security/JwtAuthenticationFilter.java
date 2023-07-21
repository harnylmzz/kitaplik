package com.example.kitaplikDemo.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.kitaplikDemo.business.concretes.UserDetailsServiceImpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class JwtAuthenticationFilter extends OncePerRequestFilter {

    //Burası bir filtre sınıfı

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException { //Bu metot http isteklerini ele alır ve filtrelerken jwt kimlik doğrulama işlemlerini gerçekleştirir.
        try {
            String jwtToken = extractJwtFromReqeust(request);
            if (StringUtils.hasText(jwtToken) && jwtTokenProvider.validateToken(jwtToken))
                ;
            Long id = jwtTokenProvider.getUserIdFromJwt(jwtToken);
            UserDetails userDetails = userDetailsServiceImpl.loadByUserId(id);
            if (userDetails != null) {
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }

        } catch (Exception e) {
            return;
        }
        filterChain.doFilter(request, response);

    }

    private String extractJwtFromReqeust(HttpServletRequest request) {
        String bearer = request.getHeader("Authorization");
        if (StringUtils.hasText(bearer) && bearer.startsWith("Bearer "))
            return bearer.substring("Bearer".length() + 1);
        return null;
    }

}
