package br.com.cruzeirodosul.easyevent.service;

import br.com.cruzeirodosul.easyevent.dto.request.EventRequestDto;
import br.com.cruzeirodosul.easyevent.entity.Address;
import br.com.cruzeirodosul.easyevent.entity.Event;
import br.com.cruzeirodosul.easyevent.enumerated.EventStatus;
import br.com.cruzeirodosul.easyevent.exception.custom.EntityNotFoundException;
import br.com.cruzeirodosul.easyevent.mapper.EventMapper;
import br.com.cruzeirodosul.easyevent.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final AddressService addressService;
    private final EventMapper eventMapper;

    @Transactional
    public Event saveNewEvent(EventRequestDto newEventRequest) {
        Event newEvent = eventMapper.from(newEventRequest);
        Address storedAddress = addressService.create(newEventRequest.getAddress());
        newEvent.setAddress(storedAddress);
        newEvent.setStatus(EventStatus.PLANNING);

        return eventRepository.save(newEvent);
    }

    @Transactional(readOnly = true)
    public Page<Event> getAllEvents(Pageable pageable) {
        return eventRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Event getEventById(Long eventId) {
        Event storedEvent = eventRepository
                .findById(eventId)
                .orElseThrow(() -> new EntityNotFoundException("Event not found."));

        Hibernate.initialize(storedEvent.getAddress());
        Hibernate.initialize(storedEvent.getUser());

        return storedEvent;
    }

}
