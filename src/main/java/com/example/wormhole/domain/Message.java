package com.example.wormhole.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String subject;

    private String message;

    @OneToMany(fetch = FetchType.EAGER)
    private List<FileImage> images;

    private Long timeOfDestruction;

    private Long departureDate;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "file_image")
    @Enumerated(EnumType.STRING)
    public List<FileImage> getImages() {
        return images;
    }

    public void setImages(List<FileImage> images) {
        this.images = images;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Long departureDate) {
        this.departureDate = departureDate;
    }

    public Long getTimeOfDestruction() {
        return timeOfDestruction;
    }

    public void setTimeOfDestruction(Long timeOfDestruction) {
        this.timeOfDestruction = timeOfDestruction;
    }
}
