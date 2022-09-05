package jung.project.zlog.service.user;

import jung.project.zlog.dto.user.UserDto;
import jung.project.zlog.entity.user.User;

public interface UserService {


    int saveUser(UserDto userDto);

    UserDto getUserByUsername(String username);


    default User dtoToEntity(UserDto dto) {

        User entity = User.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .age(dto.getAge())
                .gender(dto.getGender())
                .role(dto.getRole())
                .build();

        return entity;
    }

    default UserDto entityToDto(User entity) {

        UserDto dto = UserDto.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .email(entity.getEmail())
                .age(entity.getAge())
                .gender(entity.getGender())
                .role(entity.getRole())
                .build();

        return dto;
    }

}
