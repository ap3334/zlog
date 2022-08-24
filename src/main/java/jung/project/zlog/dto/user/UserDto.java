package jung.project.zlog.dto.user;

import jung.project.zlog.entity.user.Gender;
import jung.project.zlog.entity.user.Role;
import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {

    private int id;

    private String username;

    private String password;

    private String email;

    private int age;

    private Gender gender;

    private Role role;

}
