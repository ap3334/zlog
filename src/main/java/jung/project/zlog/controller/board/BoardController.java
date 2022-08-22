package jung.project.zlog.controller.board;

import jung.project.zlog.dto.board.BoardDto;
import jung.project.zlog.entity.board.Board;
import jung.project.zlog.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Log4j2
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public String boardList(Model model,
                            @RequestParam(value = "keyword", required = false) String keyword,
                            @RequestParam(value = "page", defaultValue = "0") int page) {

        Page<BoardDto> boards;

        if (keyword != null) {
            boards = boardService.getListBySearch(page, keyword);
        } else {
            log.info("keyword: " + keyword);


            boards = boardService.getList(page);
            log.info("boards: " + boards);
        }

        model.addAttribute("boards", boards);
        model.addAttribute("keyword", keyword);


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

    @PostMapping("/delete/{id}")
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
