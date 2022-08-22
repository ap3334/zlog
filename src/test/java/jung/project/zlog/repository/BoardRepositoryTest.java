package jung.project.zlog.repository;

import jung.project.zlog.dto.board.BoardDto;
import jung.project.zlog.entity.board.Board;
import jung.project.zlog.repository.board.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void insertBoardDummies() {

        IntStream.rangeClosed(1, 100).forEach(i -> {

            Board board = Board.builder()
                    .title("제목 ... " + i)
                    .content("내용 ... " + i)
                    .build();

            boardRepository.save(board);
        });

    }


}
