package pl.przychodniagardno.przychodniab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.przychodniagardno.przychodniab.resources.News;
import pl.przychodniagardno.przychodniab.services.NewsService;

import java.util.List;
import java.util.UUID;


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

    @GetMapping("/{id}")
    public ResponseEntity<News> getById (@PathVariable("id") Long id){
        News news = newsService.getNewsById(id);

        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    /* POST NEWS */

    @PostMapping("/add")
    public ResponseEntity<News> addNews(@RequestBody News news){
        News tempNews = newsService.addOneNewNews(news);

        return new ResponseEntity<>(tempNews, HttpStatus.CREATED);
    }

    /* PUT NEWS */

    @PutMapping("/update")
    public ResponseEntity<News> updateNews(@RequestBody News news){
        News tempNews = newsService.updateNews(news);

        return new ResponseEntity<>(tempNews, HttpStatus.OK);
    }

    /* DELETE NEWS */

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNews(@PathVariable("id") Long id){
        newsService.deleteNews(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }







}
