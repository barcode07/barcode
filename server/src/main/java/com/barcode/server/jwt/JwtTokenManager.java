package com.barcode.server.jwt;

import com.barcode.server.barcode.dao.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * PackageName : com.example.ssssksss_blog.security
 * FileName : JwtTokenManager
 * Author : 이 수 경
 * Date : 2022-04-23
 * Description :
 */
@Slf4j
@Service
public class JwtTokenManager {

    private static final String AUTHORITIES_KEY = "auth";
    private static final String BEARER_TYPE = "bearer";
    private static final long ACCESS_TOKEN_EXPIRE_TIME = 1000 * 60 * 30;            // 30분
    private static final long REFRESH_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 24 * 7;  // 7일
    private byte[] encodingKey = DatatypeConverter.parseBase64Binary("E2BBFD358D01113E9563FB3865582DA90D056C658099DEB46F2FFF95BC67C2EC");
    private Key key = Keys.hmacShaKeyFor(encodingKey);

        public String createAccessToken(User user) {
        LocalDateTime localDateTime = LocalDateTime.now().plusDays(1);
        Date date = java.sql.Timestamp.valueOf(localDateTime);
        return Jwts.builder()
                .setHeaderParam("typ","JWT")
                .setIssuedAt(new Date())
                .setExpiration(date) // 토큰 만료 시간
                .setNotBefore(new Date()) // 토큰 활성 날짜
                .claim("email",user.getEmail()) //미등록 클레임
                .signWith(key)
                .compact(); // 설정끝
    }

    public String createRefreshToken(User user) {
        LocalDateTime localDateTime = LocalDateTime.now().plusMonths(1);
        Date date = java.sql.Timestamp.valueOf(localDateTime);
        return Jwts.builder()
                .setHeaderParam("typ","JWT")
                .setIssuedAt(new Date())
                .setExpiration(date) // 토큰 만료 시간
                .setNotBefore(new Date()) // 토큰 활성 날짜
                .claim("email",user.getEmail()) //미등록 클레임
                .signWith(key)
                .compact(); // 설정끝
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            log.info("잘못된 JWT 서명입니다.");
        } catch (ExpiredJwtException e) {
            log.info("만료된 JWT 토큰입니다.");
        } catch (UnsupportedJwtException e) {
            log.info("지원되지 않는 JWT 토큰입니다.");
        } catch (IllegalArgumentException e) {
            log.info("JWT 토큰이 잘못되었습니다.");
        }
        return false;
    }

    private Claims parseClaims(String accessToken) {
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

}



//    private byte[] encodingKey = DatatypeConverter.parseBase64Binary("E2BBFD358D01113E9563FB3865582DA90D056C658099DEB46F2FFF95BC67C2EC");
//    private SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
//    private Key key = Keys.hmacShaKeyFor(encodingKey);
//    private String jwtSecret;

//    public String createAccessToken(User user) {
//        LocalDateTime localDateTime = LocalDateTime.now().plusDays(1);
//        Date date = java.sql.Timestamp.valueOf(localDateTime);
//        return Jwts.builder()
//                .setHeaderParam("typ","JWT")
//                .setIssuedAt(new Date())
//                .setExpiration(date) // 토큰 만료 시간
//                .setNotBefore(new Date()) // 토큰 활성 날짜
//                .claim("email",user.getEmail()) //미등록 클레임
//                .signWith(key)
//                .compact(); // 설정끝
//    }
//    public String createRefreshToken(User user) {
//        LocalDateTime localDateTime = LocalDateTime.now().plusMonths(1);
//        Date date = java.sql.Timestamp.valueOf(localDateTime);
//        return Jwts.builder()
//                .setHeaderParam("typ","JWT") //토큰 타입
//                .setIssuedAt(new Date()) //토큰 발행 시간
//                .setExpiration(date) // 토큰 만료 시간
//                .setNotBefore(new Date(date.getTime())) // 토큰 활성 날짜
//                .signWith(key)
//                .compact(); // 설정끝
//    }
//
//    public Claims validRefreshTokenAndReturnBody(String token) {
//        Claims claims = null;
//        try {
//            return claims = Jwts.parserBuilder()
//                    .setSigningKey(key)
//                    .build()
//                    .parseClaimsJws(token)
//                    .getBody();
//        }catch(ExpiredJwtException | UnsupportedJwtException | MalformedJwtException |  IllegalArgumentException e) {
//        }
//        finally {
//            return  claims;
//        }
//    }
//
////    토큰 검증
//    public Claims validAccessTokenAndReturnBody(String token) {
//        Claims claims = null;
//
//        try {
//            return claims = Jwts.parserBuilder()
//                    .setSigningKey(key)
//                    .build()
//                    .parseClaimsJws(token)
//                    .getBody();
//        }
//        catch(ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | IllegalArgumentException e) {
//        }
//        finally {
//            return  claims;
//        }
//    }
//
//    public boolean validateToken(String token) {
//        try {
//            Jwts.parserBuilder()
//                    .setSigningKey(key)
//                    .build()
//                    .parseClaimsJws(token);
//            return true;
//        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
//            log.info("잘못된 JWT 서명입니다.");
//        } catch (ExpiredJwtException e) {
//            log.info("만료된 JWT 토큰입니다.");
//        } catch (UnsupportedJwtException e) {
//            log.info("지원되지 않는 JWT 토큰입니다.");
//        } catch (IllegalArgumentException e) {
//            log.info("JWT 토큰이 잘못되었습니다.");
//        }
//        return false;
//    }
//
////    accessToken
//    private Claims parseClaims(String accessToken) {
//        try {
//            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody();
//        } catch (ExpiredJwtException e) {
//            return e.getClaims();
//        }
//    }
//
//
//    //    만료된 액세스 토큰에서 데이터 추출
//    public Claims expiredTokenAndReturnBody(String token) {
//        Claims claims = null;
//
//        try {
//            return claims = Jwts.parserBuilder()
//                    .setSigningKey(key)
//                    .build()
//                    .parseClaimsJws(token)
//                    .getBody();
//        }catch(UnsupportedJwtException | MalformedJwtException  | IllegalArgumentException e) {
//        }
//        finally {
//            return  claims;
//        }
//    }
//
//    // 토큰 만료
//    public Boolean isTokenExpired(String token){
//        Date expiration = validAccessTokenAndReturnBody(token).getExpiration();
//        return expiration.before(new Date());
//    }