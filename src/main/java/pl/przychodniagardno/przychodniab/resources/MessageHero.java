package pl.przychodniagardno.przychodniab.resources;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "messages")
public class MessageHero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "MESSAGE_CONTENT")
    private String text;

    @Column(name="DATE")
    private LocalDateTime date;

    @Column(name="STATUS")
    private String status;

}
