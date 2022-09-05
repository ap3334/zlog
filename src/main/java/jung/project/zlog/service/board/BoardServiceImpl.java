package jung.project.zlog.service.board;

import jung.project.zlog.dto.board.BoardDto;
import jung.project.zlog.entity.board.Board;
import jung.project.zlog.entity.user.User;
import jung.project.zlog.repository.board.BoardRepository;
import jung.project.zlog.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    private final UserRepository userRepository;


    @Override
    public Page<BoardDto> getList(int page) {

        Pageable pageable = PageRequest.of(page, 10, Sort.by("regDate").descending());

        return boardRepository.findAll(pageable).map(board -> {

            BoardDto dto = entityToDto(board);

            return dto;
        });

    }

    @Override
    public Page<BoardDto> getListBySearch(int page, String keyword) {

        Pageable pageable = PageRequest.of(page, 10, Sort.by("regDate").descending());

        return boardRepository.findBoardByTitleContaining(pageable, keyword).map(
                board -> entityToDto(board)
        );

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

    private Board dtoToEntity (BoardDto dto) {

        User user = userRepository.findByUsername(dto.getUsername()).orElseThrow(() -> new UsernameNotFoundException("해당 유저는 존재하지 않습니다."));

        Board entity = Board.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .user(user)
                .build();

        return entity;

    }

}
