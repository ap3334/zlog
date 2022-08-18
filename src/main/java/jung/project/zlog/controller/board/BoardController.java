package jung.project.zlog.controller.board;

import jung.project.zlog.dto.board.BoardDto;
import jung.project.zlog.entity.board.Board;
import jung.project.zlog.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public String boardList(Model model) {

        List<BoardDto> boards = boardService.getList();

        model.addAttribute("boards", boards);

        return "/board/list";
    }

    @GetMapping("/write")
    public String boardWrite() {

        return "/board/write";
    }

    @PostMapping("/write")
    public String boardSave(BoardDto dto) {

        Integer id = boardService.save(dto);

        // TODO 글 등록 alert 창 생성 기능 구현 필요

        return "redirect:/board/list";
    }

}
