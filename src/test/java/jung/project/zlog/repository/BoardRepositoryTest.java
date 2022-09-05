package jung.project.zlog.repository;

import jung.project.zlog.entity.board.Board;
import jung.project.zlog.entity.user.User;
import jung.project.zlog.repository.board.BoardRepository;
import jung.project.zlog.repository.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void insertBoardDummies() {

        IntStream.rangeClosed(1, 100).forEach(i -> {

            Optional<User> result = userRepository.findById((int)(Math.random() * 6) + 1);

            if (result.isPresent()) {
                User user = result.get();

                Board board = Board.builder()
                        .title("제목 ... " + i)
                        .content("내용 ... " + i)
                        .user(user)
                        .build();

                boardRepository.save(board);

            }


        });

    }


}
