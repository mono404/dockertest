package com.dockertest.dockertest.model;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class ChatMessage {

    @Id
    private String id;
    private String charId;
    private String senderId;
    private String recipientId;
    private String senderName;
    private String recipientName;
    private Date timestamp;
    private MessageStatus status;

    private String content;
    private String sender;
    private MessageType type;

    public enum MessageType {
        CHAT, LEAVE, JOIN
    }

    public enum MessageStatus {
        RECEIVED, DELIVERED
    }
}
