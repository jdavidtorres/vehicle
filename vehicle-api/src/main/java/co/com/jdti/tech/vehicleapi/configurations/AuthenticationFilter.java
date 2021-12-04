package co.com.jdti.tech.vehicleapi.configurations;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import co.com.jdti.tech.vehicleapi.helpers.TokenHelper;
import co.com.jdti.tech.vehicleapi.utils.ConstantsConfiguration;
import co.com.jdti.tech.vehicleapi.dtos.UserDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        String username = obtainUsername(request);
        String password = obtainPassword(request);
        UsernamePasswordAuthenticationToken authenticationToken = null;

        if (username != null && password != null) {
            username = username.trim();
            password = password.trim();
            authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            return authenticationManager.authenticate(authenticationToken);
        } else {
            try {
                UserDto userDto = new ObjectMapper().readValue(request.getInputStream(), UserDto.class);
                username = userDto.getUsername();
                password = userDto.getPassword();
                authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
                return authenticationManager.authenticate(authenticationToken);
            } catch (JsonParseException e) {
                authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
                authenticationToken.setAuthenticated(false);
                log.error("JsonParseException");
                e.printStackTrace();
            } catch (JsonMappingException e) {
                authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
                authenticationToken.setAuthenticated(false);
                log.error("JsonMappingException");
                e.printStackTrace();
            } catch (IOException e) {
                authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
                authenticationToken.setAuthenticated(false);
                log.error("IOException");
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        String username = ((User) authResult.getPrincipal()).getUsername();
        String token = TokenHelper.generateToken(username);
        response.addHeader(ConstantsConfiguration.HEADER, ConstantsConfiguration.PREFIX + token);
        Map<String, Object> body = new HashMap<>();
        body.put("username", username);
        body.put("token", token);
        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setStatus(HttpStatus.ACCEPTED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        logger.info("SUCCESSFUL LOGGING " + username);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException failed) throws IOException, ServletException {
        Map<String, Object> body = new HashMap<>();
        body.put(ConstantsConfiguration.MESSAGE, ConstantsConfiguration.UNSUCCESSFUL_AUTHENTICATION);
        logger.error(ConstantsConfiguration.UNSUCCESSFUL_AUTHENTICATION);
        logger.error(failed.getMessage());
        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setStatus(401);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        logger.info("UNSUCCESSFUL LOGGING");
    }
}