package com.customerintelligence.mcg.pruebatecnica.pco.pco_01;

import com.customerintelligence.mcg.pruebatecnica.feign.JsonPlaceholderClient;
import com.customerintelligence.mcg.pruebatecnica.model.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    private final JsonPlaceholderClient jsonPlaceholderClient;

    public PostController(JsonPlaceholderClient jsonPlaceholderClient) {
        this.jsonPlaceholderClient = jsonPlaceholderClient;
    }

    @GetMapping("/posts_2")
    public List<Post> getPosts() {
        return jsonPlaceholderClient.getPosts();
    }
}