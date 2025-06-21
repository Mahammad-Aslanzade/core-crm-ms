package az.company.corecrmms.service.impl;

import az.company.corecrmms.dto.user.UserResponseDto;
import az.company.corecrmms.entity.User;
import az.company.corecrmms.mapper.UserMapper;
import az.company.corecrmms.repository.UserRepository;
import az.company.corecrmms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponseDto> getAll() {
        List<User> allUsers = userRepository.findAll();
        return userMapper.mapToResponseList(allUsers);
    }
}
