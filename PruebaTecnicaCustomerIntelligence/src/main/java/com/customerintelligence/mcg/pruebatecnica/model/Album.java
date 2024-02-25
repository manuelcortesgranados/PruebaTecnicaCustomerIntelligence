package com.customerintelligence.mcg.pruebatecnica.model;

/**
 * @author Manuel Cortés Granados (manuelcortesgranados@gmail.com)
 * @since 25 Febrero 2024 3:32 AM GMT -5:00 Bogotá D.C. Colombia
 */
public class Album {

    private Long userId;
    private Long id;
    private String title;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
