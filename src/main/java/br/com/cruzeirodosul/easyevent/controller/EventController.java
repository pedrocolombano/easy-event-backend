package br.com.cruzeirodosul.easyevent.controller;

import br.com.cruzeirodosul.easyevent.dto.common.EventDto;
import br.com.cruzeirodosul.easyevent.dto.request.EventRequestDto;
import br.com.cruzeirodosul.easyevent.entity.Event;
import br.com.cruzeirodosul.easyevent.mapper.EventMapper;
import br.com.cruzeirodosul.easyevent.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/events")
public class EventController {

    private final EventService eventService;
    private final EventMapper eventMapper;

    @PostMapping
    public ResponseEntity<EventDto> createNewEvent(@RequestBody EventRequestDto newEventRequest) {
        Event storedEvent = eventService.saveNewEvent(newEventRequest);
        EventDto eventResponse = eventMapper.from(storedEvent);

        return ResponseEntity.status(HttpStatus.CREATED).body(eventResponse);
    }

    @GetMapping
    public ResponseEntity<Page<EventDto>> getAllEvents(Pageable pageable) {
        Page<Event> storedEvents = eventService.getAllEvents(pageable);
        Page<EventDto> eventsResponse = storedEvents.map(eventMapper::from);

        return ResponseEntity.ok().body(eventsResponse);
    }

    @GetMapping(path = "/{eventId}")
    public ResponseEntity<EventDto> getEventById(@PathVariable(name = "eventId") Long eventId) {
        Event storedEvent = eventService.getEventById(eventId);
        EventDto eventResponse = eventMapper.from(storedEvent);

        return ResponseEntity.ok().body(eventResponse);
    }

}
