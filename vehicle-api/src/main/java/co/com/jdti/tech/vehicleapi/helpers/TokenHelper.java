package co.com.jdti.tech.vehicleapi.helpers;

import java.nio.charset.StandardCharsets;

import javax.crypto.SecretKey;

import co.com.jdti.tech.vehicleapi.utils.ConstantsConfiguration;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class TokenHelper {

    private static String getCleanToken(String dirtyToken) {
        if (dirtyToken.contains(ConstantsConfiguration.PREFIX)) {
            return dirtyToken.replace(ConstantsConfiguration.PREFIX, "");
        } else {
            return dirtyToken;
        }
    }

    public static String generateToken(String username) {
        SecretKey key = Keys.hmacShaKeyFor(ConstantsConfiguration.SECRET.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder().setIssuer(username).signWith(key, SignatureAlgorithm.HS256).compact();
    }

    public static String getUsernameFromToken(String token) {
        try {
            SecretKey key = Keys.hmacShaKeyFor(ConstantsConfiguration.SECRET.getBytes(StandardCharsets.UTF_8));
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(getCleanToken(token)).getBody()
                    .getIssuer();
        } catch (JwtException e) {
            log.warn("don't trust the JWT!");
            return null;
        }
    }
}
