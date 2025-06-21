package az.company.corecrmms.service;

import az.company.corecrmms.dto.user.UserResponseDto;

import java.util.List;

public interface UserService {

    List<UserResponseDto> getAll();
}
