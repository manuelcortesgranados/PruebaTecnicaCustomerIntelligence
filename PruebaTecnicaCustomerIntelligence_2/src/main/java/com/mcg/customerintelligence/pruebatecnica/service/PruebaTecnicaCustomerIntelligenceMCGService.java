package com.mcg.customerintelligence.pruebatecnica.service;

import com.mcg.customerintelligence.pruebatecnica.feign.JsonPlaceholderClient;
import com.mcg.customerintelligence.pruebatecnica.feign.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PruebaTecnicaCustomerIntelligenceMCGService {

    @Autowired
    private JsonPlaceholderClient jsonPlaceholderClient;

    List<Post> getPosts(){
        List<Post> posts = jsonPlaceholderClient.getPosts();
        return posts;
    }
}
