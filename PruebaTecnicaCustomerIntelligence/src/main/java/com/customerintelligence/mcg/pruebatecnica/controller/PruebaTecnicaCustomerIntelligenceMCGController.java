package com.customerintelligence.mcg.pruebatecnica.controller;


import com.customerintelligence.mcg.pruebatecnica.feign.JsonPlaceholderClient;
import com.customerintelligence.mcg.pruebatecnica.model.Album;
import com.customerintelligence.mcg.pruebatecnica.model.Comment;
import com.customerintelligence.mcg.pruebatecnica.model.Photo;
import com.customerintelligence.mcg.pruebatecnica.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;


/**
 * @author Manuel Cortés Granados (manuelcortesgranados@gmail.com)
 * @since 25 Febrero 2024 3:09 AM GMT -5:00 Bogotá D.C. Colombia
 */
@RestController
public class PruebaTecnicaCustomerIntelligenceMCGController {

    private final JsonPlaceholderClient jsonPlaceholderClient;

    public PruebaTecnicaCustomerIntelligenceMCGController(JsonPlaceholderClient jsonPlaceholderClient) {
        this.jsonPlaceholderClient = jsonPlaceholderClient;
    }

    /**
     * @author Manuel Cortés Granados (manuelcortesgranados@gmail.com)
     * @since 25 Febrero 2024 3:10 AM GMT -5:00 Bogotá D.C. Colombia
     * @return
     */
    @GetMapping("/posts")
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

    /**
     * @author Manuel Cortés Granados (manuelcortesgranados@gmail.com)
     * @since 25 Febrero 2024 3:16 AM GMT -5:00 Bogotá D.C. Colombia
     * @return
     */
    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> getComments() {
        try {
            List<Comment> l_comments = jsonPlaceholderClient.getComments();
            return ResponseEntity.ok(l_comments);
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

    /**
     * @author Manuel Cortés Granados (manuelcortesgranados@gmail.com)
     * @since 25 Febrero 2024 3:36 AM GMT -5:00 Bogotá D.C. Colombia
     * @return
     */
    @GetMapping("/albums")
    public ResponseEntity<List<Album>> getAlbums() {
        try {
            List<Album> l_albums = jsonPlaceholderClient.getAlbums();
            return ResponseEntity.ok(l_albums);
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

    /**
     * @author Manuel Cortés Granados (manuelcortesgranados@gmail.com)
     * @since 25 Febrero 2024 3:58 AM GMT -5:00 Bogotá D.C. Colombia
     * @return
     */
    @GetMapping("/photos")
    public ResponseEntity<List<Photo>> getPhotos() {
        try {
            List<Photo> l_photos = jsonPlaceholderClient.getPhotos();
            return ResponseEntity.ok(l_photos);
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
