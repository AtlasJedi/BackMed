package pl.przychodniagardno.przychodniab.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.przychodniagardno.przychodniab.resources.MessageHero;

public interface MessageRepo extends JpaRepository<MessageHero, Integer> {


}
