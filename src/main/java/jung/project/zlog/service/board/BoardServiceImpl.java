package jung.project.zlog.service.board;

import jung.project.zlog.dto.board.BoardDto;
import jung.project.zlog.entity.board.Board;
import jung.project.zlog.repository.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;


    @Override
    public List<BoardDto> getList() {

        return boardRepository.findAll(Sort.by("regDate").descending()).stream().map(board -> {

//        return boardRepository.findAllSorted().stream().map(board -> {
            BoardDto dto = entityToDto(board);

            return dto;
        }).collect(Collectors.toList());

    }

    @Override
    public Integer save(BoardDto dto) {

        Board board = boardRepository.save(dtoToEntity(dto));

        return board.getId();
    }

    @Override
    public BoardDto showBoardDetail(int id) {

        Optional<Board> foundBoard = boardRepository.findById(id);

        if (foundBoard.isEmpty()) {
            return null;
        }
        else {
            return entityToDto(foundBoard.get());
        }

    }

    @Override
    public void deleteBoard(int id) {
        boardRepository.deleteById(id);
    }


}
