package pl.przychodniagardno.przychodniab.api.shared;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.przychodniagardno.przychodniab.resources.MessageHero;
import pl.przychodniagardno.przychodniab.resources.News;
import pl.przychodniagardno.przychodniab.services.MessageService;
import pl.przychodniagardno.przychodniab.services.NewsService;

import java.util.List;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    private final NewsService newsService;
    private final MessageService messageService;

    @Autowired
    public RestController(NewsService newsService, MessageService messageService) {
        this.newsService = newsService;
        this.messageService = messageService;
    }

    /* GET NEWS */

    @GetMapping("/news")
    public ResponseEntity<List<News>> getAllNews (){

        List<News> news = newsService.getAllNews();

        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @GetMapping("/news/getLatest")
    public ResponseEntity<News> getLatestNews (){
        News news = newsService.getLatest();

        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @GetMapping("/news/{id}")
    public ResponseEntity<News> getById (@PathVariable("id") Long id){
        News news = newsService.getNewsById(id);

        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @PostMapping("/message/new")
    public ResponseEntity<MessageHero> newMessage (@RequestBody MessageHero messageHero) {


        MessageHero tempMessageHero = messageService.saveMessage(messageHero);

        return new ResponseEntity<>(tempMessageHero,
                tempMessageHero.getStatus().equals("SAVED")
                ? HttpStatus.OK
                : HttpStatus.BAD_REQUEST);
    }










}
