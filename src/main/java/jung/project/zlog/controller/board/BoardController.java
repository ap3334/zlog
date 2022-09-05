package jung.project.zlog.controller.board;

import jung.project.zlog.config.auth.PrincipalDetails;
import jung.project.zlog.config.auth.PrincipalDetailsService;
import jung.project.zlog.dto.board.BoardDto;
import jung.project.zlog.dto.user.UserDto;
import jung.project.zlog.entity.board.Board;
import jung.project.zlog.service.board.BoardService;
import jung.project.zlog.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    private final UserService userService;

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



}
