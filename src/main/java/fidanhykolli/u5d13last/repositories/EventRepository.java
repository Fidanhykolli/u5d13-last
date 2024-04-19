package fidanhykolli.u5d13last.repositories;

import fidanhykolli.u5d13last.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByLocation(String location);

    List<Event> findByDate(LocalDate date);

    List<Event> findByTitleContainingIgnoreCase(String title);
}
