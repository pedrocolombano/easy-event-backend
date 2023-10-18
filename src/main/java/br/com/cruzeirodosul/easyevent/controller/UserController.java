package br.com.cruzeirodosul.easyevent.controller;

import br.com.cruzeirodosul.easyevent.dto.request.CreateUserDTO;
import br.com.cruzeirodosul.easyevent.dto.common.UserDTO;
import br.com.cruzeirodosul.easyevent.entity.User;
import br.com.cruzeirodosul.easyevent.mapper.UserMapper;
import br.com.cruzeirodosul.easyevent.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<UserDTO> createUser(@RequestBody @Valid CreateUserDTO createUserDTO) {
        final User createdUser = userService.create(createUserDTO);
        final UserDTO createdUserResponse = userMapper.from(createdUser);
        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                                                   .path("/{userId}")
                                                   .buildAndExpand(createdUserResponse.getId())
                                                   .toUri();

        return ResponseEntity.created(uri).body(createdUserResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        final User user = userService.findById(id);
        final UserDTO userResponse = userMapper.from(user);
        return ResponseEntity.ok(userResponse);
    }

}
