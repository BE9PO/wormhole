package com.example.wormhole.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FileExamination {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Long dateOfLoad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDateOfLoad() {
        return dateOfLoad;
    }

    public void setDateOfLoad(Long dateOfLoad) {
        this.dateOfLoad = dateOfLoad;
    }

}
