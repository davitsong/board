package org.smart.board.service;

import org.smart.board.entity.Board;
import java.util.List;

public interface BoardService {
    // 게시글 전체 데이터 가져오기
    public List<Board> findAll(int srow, int erow, String searchItem, String searchWord);
    public int insert(Board board);
    public int delete(Long boardseq);
    public int update(Board board);
    public Board findOne(Long boardseq);
    public int hitCount(Long boardseq);
    int getBoardCount(String searchItem, String searchWord);
}
