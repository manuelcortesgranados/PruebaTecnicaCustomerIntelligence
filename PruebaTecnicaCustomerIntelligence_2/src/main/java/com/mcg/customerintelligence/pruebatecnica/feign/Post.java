package com.mcg.customerintelligence.pruebatecnica.feign;

/**
 * @author Manuel Cortés Granados (manuelcortesgranados@gmail.com)
 * @since 24 Feberro 2024 8:00 AM -5:00 GMT Bogotá D.C. Colombia
 *
 */

public class Post {
    private Long id;
    private Long userId;
    private String title;
    private String body;

    // Getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
