package jung.project.zlog.service.board;

import jung.project.zlog.dto.board.BoardDto;
import jung.project.zlog.entity.board.Board;
import jung.project.zlog.repository.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;


    @Override
    public List<BoardDto> getList() {

        return boardRepository.findAll().stream().map(board -> {

            BoardDto dto = entityToDto(board);

            return dto;
        }).collect(Collectors.toList());

    }
}
