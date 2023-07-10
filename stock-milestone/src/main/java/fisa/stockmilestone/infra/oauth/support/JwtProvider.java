package fisa.stockmilestone.infra.oauth.support;

import fisa.stockmilestone.modules.global.response.BaseException;
import fisa.stockmilestone.modules.global.response.BaseResponseStatus;
import fisa.stockmilestone.modules.global.response.ExceptionResponse;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtProvider {

    private static final String JWT_DELIMITER = "\\.";
    private final SecretKey key;
    private final long validTimeInMilliseconds;

    public JwtProvider(@Value("${security.jwt.token.secret-key}") String secretKey,
                       @Value("${security.jwt.token.access.expire-length}") long validityInMilliseconds){
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
        this.validTimeInMilliseconds = validityInMilliseconds;
    }

    public String createToken(String payload){
        Date now = new Date();
        Date validTime = new Date(now.getTime() + validTimeInMilliseconds);

        return Jwts.builder()
                .setSubject(payload)
                .setIssuedAt(now)
                .setExpiration(validTime)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public void validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);

            if(!claims.getBody().getExpiration().before(new Date())){
                throw new BaseException(new ExceptionResponse(BaseResponseStatus.NOT_VALID_TOKEN));
            }
        } catch (JwtException | IllegalArgumentException e) {
            throw new BaseException(new ExceptionResponse(BaseResponseStatus.NOT_VALID_TOKEN));
        }
    }

    public String getPayloadFrom(final String jwt) {
        return jwt.split(JWT_DELIMITER)[1];
    }

    public String decodePayload(final String payload) {
        return new String(Base64.getUrlDecoder().decode(payload), StandardCharsets.UTF_8);
    }
}
