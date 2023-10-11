package br.com.cruzeirodosul.easyevent.controller;

import br.com.cruzeirodosul.easyevent.dto.request.CreateUserDTO;
import br.com.cruzeirodosul.easyevent.dto.response.UserDTO;
import br.com.cruzeirodosul.easyevent.entity.User;
import br.com.cruzeirodosul.easyevent.mapper.UserMapper;
import br.com.cruzeirodosul.easyevent.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody CreateUserDTO createUserDTO) {
        final User createdUser = userService.create(createUserDTO);
        final UserDTO createdUserResponse = userMapper.from(createdUser);
        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                                                   .path("/{userId}")
                                                   .buildAndExpand(createdUserResponse.getId())
                                                   .toUri();

        return ResponseEntity.created(uri).body(createdUserResponse);
    }

}
