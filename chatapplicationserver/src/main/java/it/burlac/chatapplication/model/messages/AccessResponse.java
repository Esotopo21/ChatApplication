package it.burlac.chatapplication.model.messages;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AccessResponse extends MessageResponse{

    public AccessResponse() {

    }

    private String content;
}
