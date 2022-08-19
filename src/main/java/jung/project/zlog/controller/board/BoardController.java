package jung.project.zlog.controller.board;

import jung.project.zlog.dto.board.BoardDto;
import jung.project.zlog.entity.board.Board;
import jung.project.zlog.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    // TODO Post Mapping으로 수정 필요
    @GetMapping("/delete/{id}")
    public String boardDelete(@PathVariable("id") int id) {

        boardService.deleteBoard(id);

        return "redirect:/board/list";
    }

    @GetMapping("/detail/{id}")
    public String showBoardDetail(@PathVariable("id") int id, Model model) {

        BoardDto board = boardService.showBoardDetail(id);

        model.addAttribute("board", board);

        return "/board/detail";

    }

}
