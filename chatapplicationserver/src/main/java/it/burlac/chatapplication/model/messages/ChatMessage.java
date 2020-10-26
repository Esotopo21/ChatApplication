package it.burlac.chatapplication.model.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ChatMessage {

    private byte[] headers;
    @JsonProperty("username")
    private String username;
    @JsonProperty("content")
    private String content;
}
