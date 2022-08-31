package jung.project.zlog.service.user;

import jung.project.zlog.dto.user.UserDto;
import jung.project.zlog.entity.user.User;

public interface UserService {


    int saveUser(UserDto userDto);

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
}
