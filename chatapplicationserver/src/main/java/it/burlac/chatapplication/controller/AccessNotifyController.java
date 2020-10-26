package it.burlac.chatapplication.controller;

import it.burlac.chatapplication.model.messages.AccessResponse;
import it.burlac.chatapplication.model.messages.AcessMessage;
import it.burlac.chatapplication.model.messages.ChatMessage;
import it.burlac.chatapplication.model.messages.ChatResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class AccessNotifyController {

    @MessageMapping("/access")
    @SendTo("/topic/access")
    public AccessResponse notifyAcess(AcessMessage message){
        log.info("Sending notification");

        String username = message.getUsername();

        AccessResponse accessResponse = new AccessResponse();
        accessResponse.setContent(username + " joined chatroom, say hi !");
        accessResponse.setSender("SERVER");

        return accessResponse;
    }

    //TODO : Creare una nuovo controller

    @MessageMapping("/chatroom")
    @SendTo("/topic/chatroom")
    public ChatResponse handleMessage(ChatMessage chatMessage){
        ChatResponse response = new ChatResponse();
        response.setUsername(chatMessage.getUsername());
        response.setContent(chatMessage.getContent());
        return response;
    }

}
