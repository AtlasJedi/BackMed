package pl.przychodniagardno.przychodniab.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.przychodniagardno.przychodniab.resources.News;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public interface NewsRepo extends JpaRepository<News, Long> {

    Optional<News> findNewsById(Long id);

    News findTopByOrderByIdDesc();
}
