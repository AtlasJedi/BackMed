package pl.przychodniagardno.przychodniab.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.hibernate.dialect.TypeNames;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class News implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID", nullable = false, updatable = false)
    private Long    id;

    @Column(name="TITLE", nullable = false)
    private String  title;

    @Lob
    @ElementCollection
    @Column(name="CONTENT_LIST", nullable = false)
    private List<String>  content;

    @Column(name="SUMMARY")
    private String summary;

    @Column(name="CATEGORY")
    private String category;

    @Column(name="IMG_URL")
    private String imgURL;

    @Column(name="READ_MORE_URL")
    private String readMoreURL;

    @Column(name="POSITION")
    private Integer position;

    @Column(name="IS_ACTIVE")
    private boolean isActive;

    @Column(name="DATE")
    private LocalDateTime   date;
}
