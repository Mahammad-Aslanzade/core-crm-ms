package az.company.corecrmms.mapper;

import az.company.corecrmms.dto.user.UserResponseDto;
import az.company.corecrmms.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    List<UserResponseDto> mapToResponseList(List<User> allUsers);

    UserResponseDto mapToResponse(User user);
}
