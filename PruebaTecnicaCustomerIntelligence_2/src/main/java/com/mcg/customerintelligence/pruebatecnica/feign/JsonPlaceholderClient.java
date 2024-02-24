package com.mcg.customerintelligence.pruebatecnica.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author Manuel Cortés Granados (manuelcortesgranados@gmail.com)
 * @since 24 Feberro 2024 8:00 AM -5:00 GMT Bogotá D.C. Colombia
 *
 */

@Component
@FeignClient(name = "jsonPlaceholderClient", url = "https://jsonplaceholder.typicode.com")
public interface JsonPlaceholderClient {

    @GetMapping("/posts")
    List<Post> getPosts();
}