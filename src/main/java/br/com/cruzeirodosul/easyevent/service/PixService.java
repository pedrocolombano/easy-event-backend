package br.com.cruzeirodosul.easyevent.service;

import br.com.cruzeirodosul.easyevent.dto.request.CreatePixDTO;
import br.com.cruzeirodosul.easyevent.entity.Pix;
import br.com.cruzeirodosul.easyevent.mapper.PixMapper;
import br.com.cruzeirodosul.easyevent.repository.PixRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PixService {

    private final PixMapper pixMapper;
    private final PixRepository pixRepository;

    @Transactional
    public Pix create(final CreatePixDTO createPixDTO) {
        final Pix card = pixMapper.from(createPixDTO);
        card.setDefaultPayment(createPixDTO.isDefaultPayment());
        return pixRepository.save(card);
    }

}
