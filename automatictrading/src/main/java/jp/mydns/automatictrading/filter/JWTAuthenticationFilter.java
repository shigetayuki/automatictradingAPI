package jp.mydns.automatictrading.filter;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.mydns.automatictrading.constant.SECURITY_CONST;
import jp.mydns.automatictrading.dto.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.userdetails.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 認証フィルター
 * login用のpathでアクセスされた際にID/PWを取り出してトークンを発行してresponseヘッダにセットする
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JWTAuthenticationFilter.class);

    private AuthenticationManager authenticationManager;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.authenticationManager = authenticationManager;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

        // ログイン用のpath
        setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(SECURITY_CONST.LOGIN_URL, "POST"));

        // ログイン用のID/PW
        setUsernameParameter(SECURITY_CONST.LOGIN_ID);
        setPasswordParameter(SECURITY_CONST.PASSWORD);

    }

    // 認証の処理
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
            // requestパラメータからユーザ情報を読み取る
            UserDto userDto = new ObjectMapper().readValue(req.getInputStream(), UserDto.class);
            HttpSession session=req.getSession();
            session.setAttribute("userDto", userDto);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userDto.getUserName(),
                            userDto.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }


    // 認証に成功した場合の処理
    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        // loginIdからtokenを設定してヘッダにセットする
        String token = Jwts.builder()
                .setSubject(((User)auth.getPrincipal()).getUsername()) // usernameだけを設定する
                .setExpiration(new Date(System.currentTimeMillis() + SECURITY_CONST.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECURITY_CONST.SECRET.getBytes())
                .compact();
        res.addHeader(SECURITY_CONST.HEADER_STRING, SECURITY_CONST.TOKEN_PREFIX + token);
        
        chain.doFilter(req, res);
    }

}
