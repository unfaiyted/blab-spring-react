package com.faiyt.blab.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Channel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ManyToOne
    private Space space;

    public Channel() {}

    public Channel(String name, String description, Space space) {
        this.name = name;
        this.description = description;
        this.space = space;
    }
}
