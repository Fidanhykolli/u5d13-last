package fidanhykolli.u5d13last.services;

import fidanhykolli.u5d13last.entities.Event;
import fidanhykolli.u5d13last.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public List<Event> getEventsByLocation(String location) {
        return eventRepository.findByLocation(location);
    }

    public List<Event> getEventsByDate(LocalDate date) {
        return eventRepository.findByDate(date);
    }

    public List<Event> getEventsByTitleContaining(String title) {
        return eventRepository.findByTitleContainingIgnoreCase(title);
    }

    public boolean isEventAvailable(Event event) {
        return event.getAvailableSeats() > 0;
    }

    // Altre operazioni di business
}
