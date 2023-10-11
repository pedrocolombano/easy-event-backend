package br.com.cruzeirodosul.easyevent.mapper;

import br.com.cruzeirodosul.easyevent.dto.request.CreateUserDTO;
import br.com.cruzeirodosul.easyevent.dto.common.UserDTO;
import br.com.cruzeirodosul.easyevent.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final ModelMapper mapper;

    public User from(final CreateUserDTO createUserDTO) {
        return mapper.map(createUserDTO, User.class);
    }

    public UserDTO from(final User user) {
        return mapper.map(user, UserDTO.class);
    }

}
