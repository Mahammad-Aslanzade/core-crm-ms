package az.company.corecrmms.service.impl;

import az.company.corecrmms.dto.GeneralResponse;
import az.company.corecrmms.dto.user.UserCreateDto;
import az.company.corecrmms.dto.user.UserRequestDto;
import az.company.corecrmms.dto.user.UserResponseDto;
import az.company.corecrmms.dto.user.VerifyAccountRequestDto;
import az.company.corecrmms.entity.Job;
import az.company.corecrmms.entity.User;
import az.company.corecrmms.exception.CommonException;
import az.company.corecrmms.exception.ExceptionEnum;
import az.company.corecrmms.mapper.UserMapper;
import az.company.corecrmms.repository.UserRepository;
import az.company.corecrmms.service.JobService;
import az.company.corecrmms.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JobService jobService;
    private final VerificationService verificationService;

    private final String COMPANY_DOMAIN = "@company.az";

    @Override
    public List<UserResponseDto> getAll() {
        List<User> allUsers = userRepository.findAll();
        return userMapper.mapToResponseList(allUsers);
    }

    @Override
    public UserResponseDto getById(String id) {
        User user = getActiveUserById(id);
        return userMapper.mapToResponse(user);
    }

    @Override
    public UserResponseDto update(String id, UserRequestDto userRequestDto) {
        return null;
    }

    @Override
    public UserResponseDto create(UserCreateDto createDto) {
        User user = createUserContext(createDto);
        userRepository.save(user);
        verificationService.sendVerification(user);
        log.info("User verification email sending to email: {}", user.getEmail());

        return userMapper.mapToResponse(user);
    }

    @Override
    public GeneralResponse deactivate(String userId) {
        User user = getActiveUserById(userId);
        userRepository.save(user);
        return new GeneralResponse(String.format("User with id %s deactivated", userId));
    }

    @Override
    public GeneralResponse verifyAccount(VerifyAccountRequestDto verifyAccountRequestDto) {
        User user = getUserByEmail(verifyAccountRequestDto.getEmail());
        verificationService.verifyAccount(user, verifyAccountRequestDto.getCode());
        user.setVerified(true);
        userRepository.save(user);
        return new GeneralResponse("User has been verified");
    }

    private User createUserContext(UserCreateDto createDto) {
        User user = userMapper.mapToEntity(createDto);
        Job currentJob = jobService.getEntityById(createDto.getCurrentJobId());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEmail(generateEmail(createDto.getName(), createDto.getSurname()));
        user.setCurrentJobId(currentJob.getId());
        user.setVerified(false);
        user.setActive(true);
        return user;
    }

    public User getActiveUserById(String userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new CommonException(ExceptionEnum.USER_NOT_FOUND_FOR_ID_EXCEPTION)
        );
    }

    private String generateEmail(String name, String surname) {
        String match = String.format("%s.%s", name.toLowerCase(), surname.toLowerCase());
        List<User> foundUserList = userRepository.findByEmailContainingAndActiveTrue(match);
        if (foundUserList.isEmpty()) {
            return match + COMPANY_DOMAIN;
        } else {
            return match + (foundUserList.size() - 1) + COMPANY_DOMAIN;
        }
    }

    private User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                () -> new CommonException(ExceptionEnum.USER_NOT_FOUND_FOR_EMAIL_EXCEPTION)
        );
    }
}
