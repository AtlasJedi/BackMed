package pl.przychodniagardno.przychodniab.api.shared;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.przychodniagardno.przychodniab.resources.News;
import pl.przychodniagardno.przychodniab.services.NewsService;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/news")
public class NewsResource {

    private final NewsService newsService;

    @Autowired
    public NewsResource(NewsService newsService) {
        this.newsService = newsService;
    }

    /* GET NEWS */

    @GetMapping("/all")
    public ResponseEntity<List<News>> getAllNews (){

        List<News> news = newsService.getAllNews();

        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @GetMapping("/getLatest")
    public ResponseEntity<News> getLatestNews (){
        News news = newsService.getLatest();

        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<News> getById (@PathVariable("id") Long id){
        News news = newsService.getNewsById(id);

        return new ResponseEntity<>(news, HttpStatus.OK);
    }










}
