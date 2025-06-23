package az.company.corecrmms.service;

import az.company.corecrmms.dto.user.UserRequestDto;
import az.company.corecrmms.dto.user.UserResponseDto;

import java.util.List;

public interface UserService {

    List<UserResponseDto> getAll();

    UserResponseDto getById(String id);

    UserResponseDto update(String id, UserRequestDto userRequestDto);
}
