package spring_react_book.todolist.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spring_react_book.todolist.model.UserEntity;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Slf4j
@Service
public class TokenProvider {
    private static final String SECRET_KEY="NMA8JPctFuna59f5MinseokKangLoveyouJooYeebinNMA8JPctFuna59f5MinseokKangLoveyouJooYeebins";

    public String create(UserEntity userEntity){

        //기한 1일
        Date expiryDate = Date.from(Instant.now().plus(1, ChronoUnit.DAYS));
        //token create
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512,SECRET_KEY)
                .setSubject(userEntity.getId())
                .setIssuer("demo app")
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .compact();
    }

    public String validateAndGetUserId(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
}
