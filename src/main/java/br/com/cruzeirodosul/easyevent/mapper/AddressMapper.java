package br.com.cruzeirodosul.easyevent.mapper;

import br.com.cruzeirodosul.easyevent.dto.common.AddressDTO;
import br.com.cruzeirodosul.easyevent.entity.Address;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressMapper {

    private final ModelMapper mapper;

    public Address from(final AddressDTO addressDTO) {
        return mapper.map(addressDTO, Address.class);
    }

}
