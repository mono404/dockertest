package com.dockertest.dockertest.model;

import lombok.Data;

@Data
public class ChatNotification {
    private String id;
    private String senderId;
    private String senderName;
}
