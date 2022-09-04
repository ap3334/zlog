package jung.project.zlog.controller.board;

import jung.project.zlog.dto.board.BoardDto;
import jung.project.zlog.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth/board")
@RequiredArgsConstructor
@Log4j2
public class BoardAuthController {

    private final BoardService boardService;

    @GetMapping("/write")
    public String boardWrite() {

        return "/board/write";
    }

    @PostMapping({"/write", "/modify"})
    public String boardSave(BoardDto dto) {

        Integer savedBoard = boardService.save(dto);

        // TODO 글 등록 alert 창 생성 기능 구현 필요

        return "redirect:/board/detail/" + savedBoard;
    }

    @GetMapping("/modify/{id}")
    public String boardModify(Model model, @PathVariable("id") int id) {

        BoardDto board = boardService.showBoardDetail(id);

        model.addAttribute("board", board);

        return "/board/modify";
    }

    @PostMapping("/delete/{id}")
    public String boardDelete(@PathVariable("id") int id) {

        boardService.deleteBoard(id);

        return "redirect:/board/list";
    }


}
