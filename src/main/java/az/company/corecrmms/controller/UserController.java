package az.company.corecrmms.controller;

import az.company.corecrmms.dto.user.UserRequestDto;
import az.company.corecrmms.dto.user.UserResponseDto;
import az.company.corecrmms.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable String id) {
        return userService.getById(id);
    }

    @PutMapping("/{id}")
    public UserResponseDto updateUser(@PathVariable String id, @RequestBody @Valid UserRequestDto userRequestDto) {
        return userService.update(id, userRequestDto);
    }

}
