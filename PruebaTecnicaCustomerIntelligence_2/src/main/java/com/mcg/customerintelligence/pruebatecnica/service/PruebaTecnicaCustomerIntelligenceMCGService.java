package com.mcg.customerintelligence.pruebatecnica.service;

import com.mcg.customerintelligence.pruebatecnica.feign.JsonPlaceholderClient;
import com.mcg.customerintelligence.pruebatecnica.feign.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;


@Service
public class PruebaTecnicaCustomerIntelligenceMCGService {

    @Autowired
    private final JsonPlaceholderClient jsonPlaceholderClient;


    @Autowired
    public PruebaTecnicaCustomerIntelligenceMCGService(JsonPlaceholderClient jsonPlaceholderClient) {
        this.jsonPlaceholderClient = jsonPlaceholderClient;
    }

    public List<Post> getPosts(){
        List<Post> posts = jsonPlaceholderClient.getPosts();
        return posts;
    }

}
