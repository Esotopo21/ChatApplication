package it.burlac.chatapplication.model.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AcessMessage {
    private byte[] headers;
    @JsonProperty("username")
    private String username;
}
