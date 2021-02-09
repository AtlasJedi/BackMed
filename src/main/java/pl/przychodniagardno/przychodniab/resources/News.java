package pl.przychodniagardno.przychodniab.resources;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.hibernate.dialect.TypeNames;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class News implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="AKT", nullable = false, updatable = false)
    private Long    id;

    private String  title;
    @Lob
    @Column()
    private String  content;
    private String  imgURL;
    private String  readMoreURL;
    private Date    date;

    public News(Long id, String title, Date date, String content, String imgURL, String readMoreURL) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.content = content;
        this.imgURL = imgURL;
        this.readMoreURL = readMoreURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public News() {
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getReadMoreURL() {
        return readMoreURL;
    }

    public void setReadMoreURL(String readMoreURL) {
        this.readMoreURL = readMoreURL;
    }
}
