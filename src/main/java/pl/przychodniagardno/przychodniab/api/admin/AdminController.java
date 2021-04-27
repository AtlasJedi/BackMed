package pl.przychodniagardno.przychodniab.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.przychodniagardno.przychodniab.resources.News;
import pl.przychodniagardno.przychodniab.services.NewsService;


@RestController
@RequestMapping("/admin")
public class AdminController {

    private final NewsService newsService;

    @Autowired
    public AdminController(NewsService newsService) { this.newsService = newsService; }


    @GetMapping("/test")
    public ResponseEntity test(){
        return new ResponseEntity("cokolwiek", HttpStatus.OK);
    }
    /* POST NEWS */

    @PostMapping ("/add")
    public ResponseEntity<News> addNews(@RequestBody News news){
        News tempNews = newsService.addOneNewNews(news);

        return new ResponseEntity<>(tempNews, HttpStatus.CREATED);
    }

    /* PUT NEWS */

    @PutMapping("/updatenews")
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
