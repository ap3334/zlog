package jung.project.zlog.service.user;

import jung.project.zlog.dto.user.UserDto;
import jung.project.zlog.entity.user.Role;
import jung.project.zlog.entity.user.User;
import jung.project.zlog.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder encoder;


    // transaction을 걸 필요가 있나?
    @Override
    public int saveUser(UserDto userDto) {

        String encodePwd = encoder.encode(userDto.getPassword());
        userDto.setPassword(encodePwd);
        userDto.setRole(Role.MEMBER);

        User user = dtoToEntity(userDto);

        userRepository.save(user);

        return user.getId();
    }

    @Override
    public UserDto getUserByUsername(String username) {

        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("해당 유저를 찾을 수 없습니다."));

        return entityToDto(user);

    }
}
