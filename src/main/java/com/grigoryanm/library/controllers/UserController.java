package com.grigoryanm.library.controllers;

import com.grigoryanm.library.jwt.JwtUtil;
import com.grigoryanm.library.models.User;
import com.grigoryanm.library.repositories.UserRepository;
import com.grigoryanm.library.services.UserService;
import jakarta.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api/v1/auth")
public class UserController {
    private final UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user){
        return userService.registerUser(user) == null ? "User with this username already exists" : "Successfully registered user!";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user, HttpServletResponse response){
        try{
            String jwtToken = jwtUtil.generateToken(user.getUsername());

            ResponseCookie cookie = ResponseCookie.from("jwt", jwtToken)
                    .httpOnly(true) // Защита от доступа через JavaScript
                    .secure(true) // Убедитесь, что это true, если вы используете HTTPS
                    .path("/") // Доступно на всех путях
                    .maxAge(24 * 60 * 60) // Срок действия 24 часа
                    .build();

            response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());

            return ResponseEntity.ok(jwtToken);
        } catch(BadCredentialsException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Bad credentials");
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpServletResponse response){
        Cookie cookie = new Cookie("jwt", null);
        cookie.setHttpOnly(true); // Защита от доступа через JavaScript
        cookie.setSecure(true); // Убедитесь, что это true, если вы используете HTTPS
        cookie.setPath("/"); // Убедитесь, что путь совпадает с тем, что использовался для установки куки
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return ResponseEntity.ok("Successfully logged out");
    }
}
