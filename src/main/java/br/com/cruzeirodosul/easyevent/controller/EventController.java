package br.com.cruzeirodosul.easyevent.controller;

import br.com.cruzeirodosul.easyevent.dto.common.EventDto;
import br.com.cruzeirodosul.easyevent.dto.request.EventRequestDto;
import br.com.cruzeirodosul.easyevent.entity.Event;
import br.com.cruzeirodosul.easyevent.service.EventService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<EventDto> createNewEvent(@RequestBody EventRequestDto newEventRequest) {
        Event newEvent = modelMapper.map(newEventRequest, Event.class);
        Event storedEvent = eventService.saveNewEvent(newEvent);
        EventDto eventResponse = modelMapper.map(storedEvent, EventDto.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(eventResponse);
    }

    @GetMapping
    public ResponseEntity<Page<EventDto>> getAllEvents(Pageable pageable) {
        Page<Event> storedEvents = eventService.getAllEvents(pageable);
        Page<EventDto> eventsResponse = storedEvents.map(element -> modelMapper.map(element, EventDto.class));
        return ResponseEntity.ok().body(eventsResponse);
    }

    @GetMapping(path = "/{eventId}")
    public ResponseEntity<EventDto> getEventById(@PathVariable(name = "eventId") Long eventId) {
        Event storedEvent = eventService.getEventById(eventId);
        EventDto eventResponse = modelMapper.map(storedEvent, EventDto.class);
        return ResponseEntity.ok().body(eventResponse);
    }

}
