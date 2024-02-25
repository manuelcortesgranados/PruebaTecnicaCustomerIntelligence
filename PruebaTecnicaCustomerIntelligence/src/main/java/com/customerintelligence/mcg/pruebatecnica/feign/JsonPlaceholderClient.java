package com.customerintelligence.mcg.pruebatecnica.feign;

import com.customerintelligence.mcg.pruebatecnica.model.Comment;
import com.customerintelligence.mcg.pruebatecnica.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Interface representing a Feign client for consuming JSONPlaceholder API.
 *
 * This interface defines methods to interact with the JSONPlaceholder API,
 * providing a structured way to retrieve data such as posts.
 *
 * Interfaz que representa un cliente Feign para consumir la API de JSONPlaceholder.
 *
 * Esta interfaz define métodos para interactuar con la API de JSONPlaceholder,
 * proporcionando una forma estructurada de recuperar datos como publicaciones.
 *
 * @author Manuel Cortés Granados (manuelcortesgranados@gmail.com)
 * @since 25 Febrero 2024 3:02 AM GMT -5:00 Bogotá D.C. Colombia
 */
@FeignClient(name = "jsonPlaceholderClient", url = "https://jsonplaceholder.typicode.com")
public interface JsonPlaceholderClient {

    /**
     * Retrieves a list of posts from the JSONPlaceholder API.
     *
     * This method sends a GET request to the "/posts" endpoint of the JSONPlaceholder API
     * to fetch a list of posts available on the platform.
     *
     * Recupera una lista de publicaciones de la API JSONPlaceholder.
     *
     * Este método envía una solicitud GET al punto final "/posts" de la API de JSONPlaceholder
     * para obtener una lista de publicaciones disponibles en la plataforma.
     *
     * @return A list of posts fetched from the JSONPlaceholder API.
     *         Una lista de publicaciones obtenidas de la API JSONPlaceholder.
     */
    @GetMapping("/posts")
    List<Post> getPosts();

    @GetMapping("/comments")
    List<Comment> getComments();

}
