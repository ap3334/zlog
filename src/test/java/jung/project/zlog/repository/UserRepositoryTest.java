package jung.project.zlog.repository;

import jung.project.zlog.dto.user.UserDto;
import jung.project.zlog.entity.user.User;
import jung.project.zlog.repository.user.UserRepository;
import jung.project.zlog.service.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserService userService;

    @Test
    public void insertUserDummies() {

        IntStream.rangeClosed(0, 5).forEach(i -> {

            UserDto user = UserDto.builder()
                    .username("user" + i)
                    .password("1234")
                    .email("user" + i + "@naver.com").build();

            userService.saveUser(user);

        });

    }

}
