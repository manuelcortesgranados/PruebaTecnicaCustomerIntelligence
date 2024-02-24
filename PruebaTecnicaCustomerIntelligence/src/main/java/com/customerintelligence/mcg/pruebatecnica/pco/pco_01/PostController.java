package com.customerintelligence.mcg.pruebatecnica.pco.pco_01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Manuel Cortés Granados (manuelcortesgranados@gmail.com)
 * @since 24 Feberro 2024 8:00 AM -5:00 GMT Bogotá D.C. Colombia
 *
 */

@RestController
public class PostController {

    private final JsonPlaceholderClient jsonPlaceholderClient;

    public PostController(JsonPlaceholderClient jsonPlaceholderClient) {
        this.jsonPlaceholderClient = jsonPlaceholderClient;
    }

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return jsonPlaceholderClient.getPosts();
    }
}