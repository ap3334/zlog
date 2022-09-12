package jung.project.zlog.controller.board;

import jung.project.zlog.config.auth.PrincipalDetails;
import jung.project.zlog.dto.board.BoardDto;
import jung.project.zlog.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

        System.out.println(dto);
        Integer savedBoard = boardService.save(dto);

        System.out.println(savedBoard);

        // TODO 글 등록 alert 창 생성 기능 구현 필요

        return "redirect:/auth/board/detail/" + savedBoard;
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
    public String showBoardDetail(@PathVariable("id") int id, Model model, @AuthenticationPrincipal PrincipalDetails principal) {

        BoardDto board = boardService.showBoardDetail(id);

        model.addAttribute("board", board);
        model.addAttribute("principal", principal);

        return "/board/detail";

    }
}
