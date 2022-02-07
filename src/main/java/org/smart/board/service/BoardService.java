package org.smart.board.service;

import org.smart.board.entity.Board;

import java.util.List;

public interface BoardService {

    //계시글 전체 데이터 가지고 오기
    public List<Board> findAll();
    public int insert(Board board);
    public int delete(Long boardseq);
    public int update(Board board);
    public Board findOne(Long boardseq);
    public int hitCount(Long boardseq);

}
