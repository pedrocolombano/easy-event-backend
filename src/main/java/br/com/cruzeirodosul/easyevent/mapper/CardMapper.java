package br.com.cruzeirodosul.easyevent.mapper;

import br.com.cruzeirodosul.easyevent.dto.request.CreateCardDTO;
import br.com.cruzeirodosul.easyevent.entity.Card;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CardMapper {

    private final ModelMapper mapper;

    public Card from(final CreateCardDTO createCardDTO) {
        TypeMap<CreateCardDTO, Card> cardMapper = mapper.typeMap(CreateCardDTO.class, Card.class);
        cardMapper.addMapping(CreateCardDTO::getCardType, Card::setType);
        return cardMapper.map(createCardDTO);
    }

}
