package com.study.server.ex3.controller;

import com.study.server.ex3.domain.Board;
import com.study.server.ex3.domain.Comment;
import com.study.server.ex3.service.BoardService;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping({"", "/", "/board"})
    public ModelAndView getIndex() {
        List<Board> boardList = boardService.readAllBoard();

        ModelAndView response = new ModelAndView("board/index");
        response.addObject(boardList);

        return response;
    }

    @PostMapping("/board")
    public String postBoard(@ModelAttribute Board inputtedBoard) {
        Board savedBoard = boardService.writeBoard(inputtedBoard);

        return "redirect:/board/" + savedBoard.getBoardId();
    }
//삭제 페이지
    @GetMapping("/board/{id}")
    public ModelAndView getPost(@PathVariable("id") Long boardId) {
        Board board = boardService.readBoard(boardId);

        System.out.println(board.getComments().toString());
        ModelAndView response = new ModelAndView("board/post");
        response.addObject(board);

        return response;
    }
    @PostMapping("/board/{id}/Modify")
    public ModelAndView ModifyBoard(@PathVariable("board_id") Long board_id){
        Board board = boardService.readBoard(board_id);

        ModelAndView response = new ModelAndView("board/Modify");
        response.addObject(board);

        return response;
    }

    @PostMapping("/board/{id}/Modify/update")
    public String updateBoard(Board board,
                              HttpServletRequest request){
        boardService.updateBoard(board);

        return "redirect:/board";
    }
}
//um..........