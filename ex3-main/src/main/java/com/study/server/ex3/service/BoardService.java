package com.study.server.ex3.service;

import com.study.server.ex3.domain.Board;
import com.study.server.ex3.repository.BoardRepository;
//import com.freehoon.web.board.model.BoardVO;

//이 부분 물어보기
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public Board writeBoard(Board inputtedBoard) {
        Board savedBoard = boardRepository.save(inputtedBoard);

        return savedBoard;
    }

    public Board readBoard(Long boardId) {
        return boardRepository.getOne(boardId);
    }

    public List<Board> readAllBoard() {
        return boardRepository.findAll();
    }

    public void removeBoard(Long board_id){
        boardRepository.deleteById(board_id);
    }

    public void updateBoard(Board board){
        Board beforeBoard = boardRepository.findById(board.getBoardId()).get();
        beforeBoard.setTitle(board.getTitle());
        beforeBoard.setContent(board.getContent());
        beforeBoard.setType(board.getType());

        boardRepository.save(beforeBoard);
    }
    //수정부분
    //public interface BoardService {
        //public List<BoardVO> getBoardList() throws Exception;
    //}
}
