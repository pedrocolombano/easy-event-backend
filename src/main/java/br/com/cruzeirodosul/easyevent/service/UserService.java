package br.com.cruzeirodosul.easyevent.service;

import br.com.cruzeirodosul.easyevent.dto.request.CreateUserDTO;
import br.com.cruzeirodosul.easyevent.dto.response.UserDTO;
import br.com.cruzeirodosul.easyevent.entity.Address;
import br.com.cruzeirodosul.easyevent.entity.User;
import br.com.cruzeirodosul.easyevent.mapper.UserMapper;
import br.com.cruzeirodosul.easyevent.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final AddressService addressService;
    private final UserRepository userRepository;

    @Transactional
    public UserDTO create(final CreateUserDTO createUserDTO) {
        final User user = userMapper.from(createUserDTO);

        Address billingAddress = addressService.create(createUserDTO.getBillingAddress());
        user.setBillingAddress(billingAddress);

        userRepository.saveAndFlush(user);
        return userMapper.from(user);
    }

}
