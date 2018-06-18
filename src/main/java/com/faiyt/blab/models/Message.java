package com.faiyt.blab.models;


import com.faiyt.blab.models.user.User;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class Message {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User sentBy;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime sentAt;

    private String message;

    public Message() {}

    public Message(User sentBy, LocalDateTime createdAt, LocalDateTime sentAt, String message) {
        this.sentBy = sentBy;
        this.createdAt = createdAt;
        this.sentAt = sentAt;
        this.message = message;
    }




}
