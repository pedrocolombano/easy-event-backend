package br.com.cruzeirodosul.easyevent.service;

import br.com.cruzeirodosul.easyevent.dto.common.AddressDTO;
import br.com.cruzeirodosul.easyevent.dto.request.CreateCardDTO;
import br.com.cruzeirodosul.easyevent.dto.request.CreatePixDTO;
import br.com.cruzeirodosul.easyevent.dto.request.CreateUserDTO;
import br.com.cruzeirodosul.easyevent.entity.Address;
import br.com.cruzeirodosul.easyevent.entity.Card;
import br.com.cruzeirodosul.easyevent.entity.Pix;
import br.com.cruzeirodosul.easyevent.entity.User;
import br.com.cruzeirodosul.easyevent.exception.custom.EntityNotFoundException;
import br.com.cruzeirodosul.easyevent.mapper.UserMapper;
import br.com.cruzeirodosul.easyevent.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final AddressService addressService;
    private final CardService cardService;
    private final PixService pixService;
    private final UserRepository userRepository;

    @Transactional
    public User create(final CreateUserDTO createUserDTO) {
        final User user = userMapper.from(createUserDTO);
        setUserBillingAddress(user, createUserDTO.getBillingAddress());
        setUserPaymentCard(user, createUserDTO.getPaymentCard());
        setUserPix(user, createUserDTO.getPixPayment());

        return userRepository.save(user);
    }

    private void setUserBillingAddress(final User user, final AddressDTO addressDTO) {
        final Address billingAddress = addressService.create(addressDTO);
        user.setBillingAddress(billingAddress);
    }

    private void setUserPaymentCard(final User user, final CreateCardDTO createCardDTO) {
        final Card paymentCard = cardService.create(createCardDTO);
        user.getPayments().add(paymentCard);
    }

    private void setUserPix(final User user, final CreatePixDTO createPixDTO) {
        final Pix pix = pixService.create(createPixDTO);
        user.getPayments().add(pix);
    }

    @Transactional(readOnly = true)
    public User findById(final Long id) {
        final User user = userRepository.findById(id)
                                        .orElseThrow(() -> new EntityNotFoundException(String.format("User with ID %d not found.", id)));
        Hibernate.initialize(user.getBillingAddress());
        return user;
    }

}
