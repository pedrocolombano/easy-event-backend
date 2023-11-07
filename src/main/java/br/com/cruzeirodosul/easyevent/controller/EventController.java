package br.com.cruzeirodosul.easyevent.controller;

import br.com.cruzeirodosul.easyevent.dto.common.EventDto;
import br.com.cruzeirodosul.easyevent.dto.request.EventRequestDto;
import br.com.cruzeirodosul.easyevent.dto.response.DetailedEventDto;
import br.com.cruzeirodosul.easyevent.entity.Event;
import br.com.cruzeirodosul.easyevent.mapper.EventMapper;
import br.com.cruzeirodosul.easyevent.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ResponseEntity<List<EventDto>> getAllEvents(Pageable pageable) {
        Page<Event> storedEvents = eventService.getAllEvents(pageable);
        Page<EventDto> eventsResponse = storedEvents.map(eventMapper::from);

        return ResponseEntity.ok().body(eventsResponse.getContent());
    }

    @GetMapping(path = "/{eventId}")
    public ResponseEntity<DetailedEventDto> getEventById(@PathVariable Long eventId) {
        Event storedEvent = eventService.getEventById(eventId);
        DetailedEventDto eventResponse = eventMapper.toDetailedDto(storedEvent);

        return ResponseEntity.ok().body(eventResponse);
    }

}
