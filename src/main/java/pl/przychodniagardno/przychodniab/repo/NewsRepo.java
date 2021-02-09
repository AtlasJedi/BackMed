package pl.przychodniagardno.przychodniab.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.przychodniagardno.przychodniab.resources.News;

import java.util.Optional;

public interface NewsRepo extends JpaRepository<News, Long> {

    Optional<News> findNewsById(Long id);
}
