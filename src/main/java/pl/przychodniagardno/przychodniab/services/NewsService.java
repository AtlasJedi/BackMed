package pl.przychodniagardno.przychodniab.services;

import org.aspectj.weaver.ast.Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.przychodniagardno.przychodniab.exceptionHandler.NewsNotFoundException;
import pl.przychodniagardno.przychodniab.repo.NewsRepo;
import pl.przychodniagardno.przychodniab.resources.News;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class NewsService {

    private final NewsRepo newsRepo;

    @Autowired
    public NewsService(NewsRepo newsRepo) {
        this.newsRepo = newsRepo;
    }

    public News addOneNewNews(News news) {
        News tempNews = new News();
        tempNews.setDate(LocalDateTime.now());
        tempNews.setContent(news.getContent());
        tempNews.setSummary(news.getSummary());

        tempNews.setCategory(news.getCategory() != null ? news.getCategory() : "announcement");

        tempNews.setImgURL(news.getImgURL() == null ? "url(assets/img/default.jpg)" : "url(assets/img/"+news.getImgURL()+")");
        tempNews.setTitle(news.getTitle());
        tempNews.setActive(true);
        tempNews.setReadMoreURL(news.getReadMoreURL());

        return newsRepo.save(tempNews);
    }

    public List<News> getAllNews() {
        List<News> newsList = newsRepo.findAll().stream()
                .sorted(Comparator.comparing(News::getDate).reversed())
                .collect(Collectors.toList());;


        return newsList;
    }

    public News getLatest(){
        News news = newsRepo.findTopByOrderByIdDesc();

        return news;
    }

    public News getNewsById(Long id){

        return newsRepo.findNewsById(id)
                .orElseThrow(() -> new NewsNotFoundException("News id: " +id+ " not fount."));
    }

    public News updateNews (News news){

        return newsRepo.save(news);
    }

    public void deleteNews (Long id){

        newsRepo.deleteById(id);
    }


}
