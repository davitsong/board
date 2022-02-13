package org.smart.board.dao;

import org.apache.ibatis.annotations.Mapper;
import org.smart.board.entity.Board;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardDao {
    public List<Board> findAll(Map<String, Object> map);
    public int insert(Board board);
    public int delete(Long boardseq);
    public int update(Board board);
    public Board findOne(Long boardseq);
    public int hitCount(Long boardseq);
    public int getBoardCount(Map<String, String> map);

}
