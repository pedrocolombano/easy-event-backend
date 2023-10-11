package br.com.cruzeirodosul.easyevent.mapper;

import br.com.cruzeirodosul.easyevent.dto.common.EventDto;
import br.com.cruzeirodosul.easyevent.dto.request.EventRequestDto;
import br.com.cruzeirodosul.easyevent.dto.response.DetailedEventDto;
import br.com.cruzeirodosul.easyevent.entity.Event;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventMapper {

    private final ModelMapper modelMapper;

    public Event from(final EventRequestDto eventRequestDto) {
        return modelMapper.map(eventRequestDto, Event.class);
    }

    public EventDto from(final Event event) {
        return modelMapper.map(event, EventDto.class);
    }

    public DetailedEventDto toDetailedDto(final Event event) {
        return modelMapper.map(event, DetailedEventDto.class);
    }

}
