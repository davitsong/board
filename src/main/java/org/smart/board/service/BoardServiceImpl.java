package org.smart.board.service;


import org.smart.board.dao.BoardDao;
import org.smart.board.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements  BoardService {
    @Autowired
    private BoardDao boardDao;

    @Override
    public List<Board> findAll() {
        List<Board> boardList = boardDao.findAll();
        return boardList;
    }

    @Override
    public int insert(Board board) {
        int result = boardDao.insert(board);
        return result;
    }

    @Override
    public int delete(Long boardseq) {
        return 0;
    }

    @Override
    public int update(Board board) {
        return 0;
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
}
