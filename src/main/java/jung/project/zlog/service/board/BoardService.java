package jung.project.zlog.service.board;

import jung.project.zlog.dto.board.BoardDto;
import jung.project.zlog.entity.board.Board;
import jung.project.zlog.entity.user.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {

    Page<BoardDto> getList(int page);

    Page<BoardDto> getListBySearch(int page, String keyword);

    Integer save(BoardDto dto);

    BoardDto showBoardDetail(int id);

    void deleteBoard(int id);



    default BoardDto entityToDto (Board entity) {

        BoardDto dto = BoardDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .username(entity.getUser().getUsername())
                .build();

        return dto;

    }

}
