package az.company.corecrmms.service;

import az.company.corecrmms.dto.GeneralResponse;
import az.company.corecrmms.dto.user.UserCreateDto;
import az.company.corecrmms.dto.user.UserRequestDto;
import az.company.corecrmms.dto.user.UserResponseDto;
import az.company.corecrmms.dto.user.VerifyAccountRequestDto;

import java.util.List;

public interface UserService {

    List<UserResponseDto> getAll();

    UserResponseDto getById(String id);

    UserResponseDto update(String id, UserRequestDto userRequestDto);

    UserResponseDto create(UserCreateDto createDto);

    GeneralResponse deactivate(String userId);

    GeneralResponse verifyAccount(VerifyAccountRequestDto verifyAccountRequestDto);
}
