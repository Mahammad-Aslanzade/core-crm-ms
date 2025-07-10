package az.company.corecrmms.service.impl;

import az.company.corecrmms.dto.user.UserCreateDto;
import az.company.corecrmms.dto.user.UserRequestDto;
import az.company.corecrmms.dto.user.UserResponseDto;
import az.company.corecrmms.entity.Job;
import az.company.corecrmms.entity.User;
import az.company.corecrmms.mapper.UserMapper;
import az.company.corecrmms.repository.UserRepository;
import az.company.corecrmms.service.JobService;
import az.company.corecrmms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JobService jobService;
    private final String COMPANY_DOMAIN = "@company.az";

    @Override
    public List<UserResponseDto> getAll() {
        List<User> allUsers = userRepository.findAll();
        return userMapper.mapToResponseList(allUsers);
    }

    @Override
    public UserResponseDto getById(String id) {
        User user = userRepository.findById(id).orElseThrow();
        return userMapper.mapToResponse(user);
    }

    @Override
    public UserResponseDto update(String id, UserRequestDto userRequestDto) {
        return null;
    }

    @Override
    public UserResponseDto create(UserCreateDto createDto) {
        User user = userMapper.mapToEntity(createDto);
        Job currentJob = jobService.getEntityById(createDto.getCurrentJobId());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEmail(generateEmail(createDto.getName(), createDto.getSurname()));
        user.setCurrentJobId(currentJob.getId());
        userRepository.save(user);
        return userMapper.mapToResponse(user);
    }

    private String generateEmail(String name, String surname) {
        String match = String.format("%s.%s", name.toLowerCase(), surname.toLowerCase());
        List<User> foundUserList = userRepository.findByEmailContaining(match);
        if (foundUserList.isEmpty()) {
            return match + COMPANY_DOMAIN;
        } else {
            return match + (foundUserList.size() - 1) + COMPANY_DOMAIN;
        }
    }
}
