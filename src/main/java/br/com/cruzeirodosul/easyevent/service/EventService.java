package br.com.cruzeirodosul.easyevent.service;

import br.com.cruzeirodosul.easyevent.entity.Event;
import br.com.cruzeirodosul.easyevent.exception.custom.EntityNotFoundException;
import br.com.cruzeirodosul.easyevent.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public Event saveNewEvent(Event newEvent) {
        return eventRepository.save(newEvent);
    }

    @Transactional(readOnly = true)
    public Page<Event> getAllEvents(Pageable pageable) {
        return eventRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Event getEventById(Long eventId) {
        Optional<Event> optionalEvent = eventRepository.findById(eventId);
        return optionalEvent.orElseThrow(() -> new EntityNotFoundException("Event not found."));
    }

}
