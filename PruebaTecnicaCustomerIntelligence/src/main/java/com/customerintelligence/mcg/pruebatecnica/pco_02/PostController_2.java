package com.customerintelligence.mcg.pruebatecnica.pco_02;


import com.customerintelligence.mcg.pruebatecnica.pco_01.JsonPlaceholderClient;
import com.customerintelligence.mcg.pruebatecnica.pco_01.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

/**
 * Controlador REST para manejar solicitudes relacionadas con publicaciones.
 * Este controlador se encarga de consumir el servicio JSONPlaceholder para obtener las publicaciones disponibles.
 * Proporciona endpoints para recuperar información sobre las publicaciones disponibles.
 * Además de manejar solicitudes exitosas, este controlador también gestiona errores de cliente y servidor de manera adecuada.
 * Los errores de cliente, como solicitudes no encontradas (HTTP 404), se manejan devolviendo una respuesta 404.
 * Los errores de servidor inesperados se registran para fines de depuración y se devuelve una respuesta 500.
 *
 * REST Controller to handle requests related to posts.
 * This controller is responsible for consuming the JSONPlaceholder service to fetch available posts.
 * It provides endpoints to retrieve information about the available posts.
 * In addition to handling successful requests, this controller also manages client and server errors appropriately.
 * Client errors, such as not found requests (HTTP 404), are handled by returning a 404 response.
 * Unexpected server errors are logged for debugging purposes, and a 500 response is returned.
 *
 * @author Manuel Cortés Granados (manuelcortesgranados@gmail.com)
 * @since 24 Febrero 2024 8:00 AM -5:00 GMT Bogotá D.C. Colombia
 */


@RestController
public class PostController_2 {

    private final JsonPlaceholderClient jsonPlaceholderClient;

    public PostController_2(JsonPlaceholderClient jsonPlaceholderClient) {
        this.jsonPlaceholderClient = jsonPlaceholderClient;
    }

    @GetMapping("/posts_1")
    public ResponseEntity<List<Post>> getPosts() {
        try {
            List<Post> posts = jsonPlaceholderClient.getPosts();
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
