package com.customerintelligence.mcg.pruebatecnica.controller;


import com.customerintelligence.mcg.pruebatecnica.feign.JsonPlaceholderClient;
import com.customerintelligence.mcg.pruebatecnica.model.*;
import com.customerintelligence.mcg.pruebatecnica.model.User.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;


/**
 * @author Manuel Cortés Granados (manuelcortesgranados@gmail.com)
 * @since 25 Febrero 2024 3:09 AM GMT -5:00 Bogotá D.C. Colombia
 */
@RestController
public class PruebaTecnicaCustomerIntelligenceMCGController {


    private final ObjectMapper objectMapper = new ObjectMapper();

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

    /**
     * @author Manuel Cortés Granados (manuelcortesgranados@gmail.com)
     * @since 25 Febrero 2024 4:20 AM GMT -5:00 Bogotá D.C. Colombia
     * @return
     */
    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getTodos() {
        try {
            List<Todo> l_todos = jsonPlaceholderClient.getTodos();
            return ResponseEntity.ok(l_todos);
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
     * @since 25 Febrero 2024 6:40 AM GMT -5:00 Bogotá D.C. Colombia
     * @return
     */
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUser() {
        try {
            List<User> l_users = jsonPlaceholderClient.getUsers();
            return ResponseEntity.ok(l_users);
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
     * @since 25 Febrero 2024 6:06 PM GMT -5:00 Bogotá D.C. Colombia
     * @return
     */
    @GetMapping("/posts/{id}")
    public ResponseEntity<CustomResponse<Post>> getPostById(@PathVariable Long id) {
        CustomResponse<Post> response = new CustomResponse<>();
        try {
            Post post = jsonPlaceholderClient.getPostById(id);
            response.setSuccess(true);
            response.setData(post);
            return ResponseEntity.ok(response);

        }  catch (Exception e) {
            response.setSuccess(false);
            response.setErrorMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    /**
     * @author Manuel Cortés Granados (manuelcortesgranados@gmail.com)
     * @since 26 Febrero 2024 5:03 AM GMT -5:00 Bogotá D.C. Colombia
     * @return
     */
    @GetMapping("/posts/{id}/comments")
    public ResponseEntity<CustomResponse<List<Comment>>> getPostCommentsById(@PathVariable Long id) {
        CustomResponse<List<Comment>> response = new CustomResponse<>();
        List<Comment> comments = null;
        try {
            comments = jsonPlaceholderClient.getPostCommentsById(id);
            response.setSuccess(true);
            response.setData(comments);
            return ResponseEntity.ok(response);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                response.setSuccess(false);
                response.setErrorMessage("No comments found for post with ID: " + id);
                System.out.println("No comments found for post with ID: " + id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            // Handle other client errors
            response.setSuccess(false);
            response.setErrorMessage("Client error: " + e.getStatusCode().toString());
            System.out.println("Client error: " + e.getStatusCode().toString());
            return ResponseEntity.status(e.getStatusCode()).body(response);
        } catch (Exception e) {
            // Log the exception for debugging purposes
            response.setSuccess(false);
            response.setErrorMessage("Internal server error occurred: " + e.getMessage());
            System.out.println("Internal server error occurred: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }finally {
            if (comments.size()==0){
                response.setSuccess(false);
                response.setErrorMessage("No se encontraron comentarios con el id : " + id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        }
    }

    /**
     * @author Manuel Cortés Granados (manuelcortesgranados@gmail.com)
     * @since 26 Febrero 2024 5:03 AM GMT -5:00 Bogotá D.C. Colombia
     * @return
     */
    @PostMapping("/posts")
    public ResponseEntity<Post> createResourcePost(@RequestBody Post post) {
        try {
            Post post1 = jsonPlaceholderClient.createResourcePost(post);
            return ResponseEntity.ok(post1);
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
     * @since 26 Febrero 2024 5:03 AM GMT -5:00 Bogotá D.C. Colombia
     * @return
     */
    @PutMapping("/posts/{id}")
    public ResponseEntity<CustomResponse<Post>> updateResourcePost(@PathVariable Long id,@RequestBody Post post) {
        CustomResponse<Post> response = new CustomResponse<>();
        Post post1=null;
        try {
            post1 = jsonPlaceholderClient.updateResourcePost(id,post);
            response.setSuccess(true);
            response.setData(post1);
            return ResponseEntity.ok(response);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            if (post1==null){
                response.setSuccess(false);
                response.setErrorMessage("No se encontraron comentarios con el id : " + id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        }
        return null;
    }

    /**
     * @author Manuel Cortés Granados (manuelcortesgranados@gmail.com)
     * @since 26 Febrero 2024 5:37 AM GMT -5:00 Bogotá D.C. Colombia
     * @return
     */
    private String convertToJson(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

}
