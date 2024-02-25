package com.mcg.customerintelligence.pruebatecnica.jwt.controller;

import com.mcg.customerintelligence.pruebatecnica.feign.Post;
import com.mcg.customerintelligence.pruebatecnica.jwt.model.JwtRequest;
import com.mcg.customerintelligence.pruebatecnica.jwt.model.JwtResponse;
import com.mcg.customerintelligence.pruebatecnica.jwt.service.UserService;
import com.mcg.customerintelligence.pruebatecnica.jwt.utility.JWTUtility;
import com.mcg.customerintelligence.pruebatecnica.service.PruebaTecnicaCustomerIntelligenceMCGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private PruebaTecnicaCustomerIntelligenceMCGService pruebaTecnicaCustomerIntelligenceMCGService;
    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        return "Welcome to Daily Code Buffer!!";
    }

    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails
                = userService.loadUserByUsername(jwtRequest.getUsername());

        final String token =
                jwtUtility.generateToken(userDetails);

        return  new JwtResponse(token);
    }

    @GetMapping("/posts_1")
    public ResponseEntity<List<Post>> getPosts() {
        try {
            List<Post> posts = pruebaTecnicaCustomerIntelligenceMCGService.getPosts();
            return ResponseEntity.ok(posts);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                return ResponseEntity.notFound().build();
            }
            // Handle other client errors
            return ResponseEntity.status(e.getStatusCode()).body(null);
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
