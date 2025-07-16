package az.company.corecrmms.controller;

import az.company.corecrmms.dto.GeneralResponse;
import az.company.corecrmms.dto.user.UserCreateDto;
import az.company.corecrmms.dto.user.UserRequestDto;
import az.company.corecrmms.dto.user.UserResponseDto;
import az.company.corecrmms.dto.user.VerifyAccountRequestDto;
import az.company.corecrmms.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/me")
    public UserResponseDto getCurrentUser() {
        // TODO will be implemented
        return null;
    }

    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable String id) {
        return userService.getById(id);
    }

    @PostMapping
    public UserResponseDto create(@RequestBody @Valid UserCreateDto createDto) {
        return userService.create(createDto);
    }

    @PostMapping("/verify")
    public GeneralResponse verifyAccount(@RequestBody @Valid VerifyAccountRequestDto verifyAccountRequestDto){
        return userService.verifyAccount(verifyAccountRequestDto);
    }

    @PutMapping("/{id}")
    public UserResponseDto updateUser(@PathVariable String id, @RequestBody @Valid UserRequestDto userRequestDto) {
        return userService.update(id, userRequestDto);
    }

    @PatchMapping("/{userId}/deactivate")
    public GeneralResponse deactivate(@PathVariable String userId) {
        return userService.deactivate(userId);
    }

}
