package pl.przychodniagardno.przychodniab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.przychodniagardno.przychodniab.repo.MessageRepo;
import pl.przychodniagardno.przychodniab.resources.MessageHero;

import java.time.LocalDateTime;

@Service
public class MessageService {

    private final MessageRepo messageRepo;

    @Autowired
    public MessageService(MessageRepo messageRepo, MessageRepo messageRepo1) {
        this.messageRepo = messageRepo1;

    }

    public MessageHero saveMessage (MessageHero messageHero) {

        MessageHero tempMessageHero = messageHero;
        messageHero.setDate(LocalDateTime.now());

        try {
            messageRepo.save(tempMessageHero);
        } catch (Exception e) {
           tempMessageHero.setStatus("e: "  + tempMessageHero.getDate() );
           return tempMessageHero;
        }
        messageHero.setStatus("SAVED");
        return tempMessageHero;
    }
}
