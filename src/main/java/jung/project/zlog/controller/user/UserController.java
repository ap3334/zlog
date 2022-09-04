package jung.project.zlog.controller.user;

import jung.project.zlog.dto.user.UserDto;
import jung.project.zlog.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/join")
    public String joinPage() {

        return "/user/join";
    }

    @PostMapping("/join")
    public ResponseEntity<Integer> join(@RequestBody UserDto userDto) {

        int id = userService.saveUser(userDto);

        return new ResponseEntity<>(200, HttpStatus.OK);

    }

    @GetMapping("/login")
    public String loginPage() {

        return "/user/login";
    }


}
