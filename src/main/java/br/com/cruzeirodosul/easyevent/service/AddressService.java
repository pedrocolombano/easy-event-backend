package br.com.cruzeirodosul.easyevent.service;

import br.com.cruzeirodosul.easyevent.dto.AddressDTO;
import br.com.cruzeirodosul.easyevent.entity.Address;
import br.com.cruzeirodosul.easyevent.mapper.AddressMapper;
import br.com.cruzeirodosul.easyevent.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressMapper addressMapper;
    private final AddressRepository addressRepository;

    @Transactional
    public Address create(final AddressDTO addressDTO) {
        Address address = addressMapper.from(addressDTO);
        return addressRepository.save(address);
    }

}
