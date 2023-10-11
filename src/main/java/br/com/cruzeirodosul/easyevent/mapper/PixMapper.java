package br.com.cruzeirodosul.easyevent.mapper;

import br.com.cruzeirodosul.easyevent.dto.request.CreatePixDTO;
import br.com.cruzeirodosul.easyevent.entity.Pix;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PixMapper {

    private final ModelMapper mapper;

    public Pix from(final CreatePixDTO createPixDTO) {
        return mapper.map(createPixDTO, Pix.class);
    }

}
