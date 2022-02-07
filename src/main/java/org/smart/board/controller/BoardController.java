package org.smart.board.controller;


import org.smart.board.entity.Board;
import org.smart.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/boardList")
    public String boardList(Model model){
        List<Board> boardList = boardService.findAll();
        //System.out.println("boardList");
        model.addAttribute("boardList",boardList);
        return  "board/boardList";
    }

    @GetMapping("/boardWrite")
    public String boardWrite(){
        return "board/boardWrite";
    }

    @PostMapping("/boardWrite")
    public String boardWrite(Board board){

        board.setUsrid("aaa");
        System.out.println("=============board");
        //DB저장
        boardService.insert(board);

        return "redirect:/board/boardList";

    }

    @GetMapping("/boardDetail")
    public String boardDetail(Long boardseq, Model model){

        //1) DB에서 boardseq에 해당하는 하나의 글을 질의해옴
        //1-1) 조회수 증가해야함
        Board board = boardService.findOne(boardseq);
        int hitcount = boardService.hitCount(boardseq);

        //2) Model에 저장(--> board-> hitcount setting)
        board.setHitcount(hitcount);
        model.addAttribute("board",board);

        //3) View로 forward
        return  "board/boardDetail";

    }


}

