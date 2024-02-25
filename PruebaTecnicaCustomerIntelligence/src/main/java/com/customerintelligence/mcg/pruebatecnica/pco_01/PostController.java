package com.customerintelligence.mcg.pruebatecnica.pco_01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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