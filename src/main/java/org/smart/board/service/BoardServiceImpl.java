package org.smart.board.service;

import org.smart.board.dao.BoardDao;
import org.smart.board.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements  BoardService{
    @Autowired
    private BoardDao boardDao;

    @Override
    public List<Board> findAll(int srow, int erow, String searchItem, String searchWord) {
        Map<String, Object> map = new HashMap<>();
        map.put("srow", srow);
        map.put("erow", erow);
        map.put("searchItem", searchItem);
        map.put("searchWord", searchWord);
        List<Board> boardList = boardDao.findAll(map);

        return boardList;
    }

    @Override
    public int insert(Board board) {
        int result = boardDao.insert(board);
        return result;
    }

    @Override
    public int delete(Long boardseq) {
        int result = boardDao.delete(boardseq);
        return result;
    }

    @Override
    public int update(Board board) {
        int result = boardDao.update(board);
        return result;
    }

    @Override
    public Board findOne(Long boardseq) {
        Board board = boardDao.findOne(boardseq);

        return board;
    }

    @Override
    public int hitCount(Long boardseq) {
        int hitcount = boardDao.hitCount(boardseq);
        return hitcount;
    }

    @Override
    public int getBoardCount(String searchItem, String searchWord){
        Map<String, String> map = new HashMap<>();

        map.put("searchItem",searchItem);
        map.put("searchWord",searchWord);
        int totalRecordCount = boardDao.getBoardCount(map);
        return totalRecordCount;
    }
}
