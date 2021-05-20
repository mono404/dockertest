package com.dockertest.dockertest.controller;

import com.dockertest.dockertest.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
//@Controller
public class ChatController {

    @GetMapping(path = "/")
    public ModelAndView Chatting() {
        return new ModelAndView("/index");
    }

    @MessageMapping("/out")
    @SendTo("/topic/out")
    public String outroom(String message) throws Exception {
        System.out.println("out message : " + message);
        return message;
    }

    @MessageMapping("/in")
    @SendTo("/topic/in")
    public String inroom(String message) throws Exception {
        System.out.println("in message : " + message);
        return message;
    }

    @MessageMapping("/chat.register")
    @SendTo("/topic/public")
    public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }
}
