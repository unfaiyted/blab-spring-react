package com.faiyt.blab.models;


import com.faiyt.blab.models.user.User;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@Entity
public class MessageChannel extends Message {

    @ManyToOne
    private Channel sentTo;

    public MessageChannel(User sentBy, LocalDateTime createdAt, LocalDateTime sentAt, String message, Channel sentTo) {
        super(sentBy, createdAt, sentAt, message);
        this.sentTo = sentTo;
    }

}
