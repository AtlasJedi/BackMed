package pl.przychodniagardno.przychodniab.services;

import org.aspectj.weaver.ast.Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.przychodniagardno.przychodniab.exceptionHandler.NewsNotFoundException;
import pl.przychodniagardno.przychodniab.repo.NewsRepo;
import pl.przychodniagardno.przychodniab.resources.News;

import java.util.Calendar;
import java.util.List;


@Service
public class NewsService {

    private final NewsRepo newsRepo;

    @Autowired
    public NewsService(NewsRepo newsRepo) {
        this.newsRepo = newsRepo;
    }

    public News addOneNewNews(News news) {
        News tempNews = new News();
        tempNews.setDate(Calendar.getInstance().getTime());
        tempNews.setContent(news.getContent());
        tempNews.setImgURL(news.getImgURL());
        tempNews.setTitle(news.getTitle());

        return newsRepo.save(tempNews);
    }

    public List<News> getAllNews() {
        List<News> newsList = newsRepo.findAll();

        return newsList;
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
