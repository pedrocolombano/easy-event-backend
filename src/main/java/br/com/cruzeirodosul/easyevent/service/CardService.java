package br.com.cruzeirodosul.easyevent.service;

import br.com.cruzeirodosul.easyevent.dto.request.CreateCardDTO;
import br.com.cruzeirodosul.easyevent.entity.Card;
import br.com.cruzeirodosul.easyevent.mapper.CardMapper;
import br.com.cruzeirodosul.easyevent.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardMapper cardMapper;
    private final CardRepository cardRepository;

    @Transactional
    public Card create(final CreateCardDTO createCardDTO) {
        final Card card = cardMapper.from(createCardDTO);
        card.setDefaultPayment(createCardDTO.isDefaultPayment());
        return cardRepository.save(card);
    }

}
