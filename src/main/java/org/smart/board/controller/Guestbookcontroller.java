package org.smart.board.controller;


import org.smart.board.entity.Guestbook;
import org.smart.board.service.GuestbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/guestbook")
public class Guestbookcontroller {

    @Autowired
    private GuestbookService guestbookService;

    /*
        방명록에 대한 목록 요청
     */

    @GetMapping("/guestbookList")
    public String guestbookList(Model model){
        //DB 연동되는 추가작업 필요
        List<Guestbook> guestbookList = guestbookService.guestbookList();
        model.addAttribute("guestbookList", guestbookList);
       return "guestbook/guestbookList";

    }
    //글등록 화면
    @GetMapping("/guestbookWrite")
    public String guestbookWrite(){
        return "guestbook/guestbookWrite";  //forward
    }

    @PostMapping("/guestbookWrite")
    public String guestbookWrite(Guestbook guestbook){
        //System.out.println("==========방명록 글"+guestbook);
        guestbookService.guestbookWrite(guestbook);

        return "redirect:/guestbook/guestbookList"; //guestbook List로 요청 --> 브라우저한테 신호를 보냄

    }

    @GetMapping("/guestbookDelete")
    public String guestbookDelete(Long seq, String password){
        System.out.println(seq + ","+ password);
        // 삭제하기
        Map<String, Object> map = new HashMap<>();

        map.put("seq",seq);
        map.put("password",password);

        guestbookService.guestbookDelete(map);

        return "redirect:/guestbook/guestbookList"; //브라우저에게 컨트롤러의 메소드를 재호출 하도록함

    }
}
