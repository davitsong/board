package org.smart.board.dao;

import org.apache.ibatis.annotations.Mapper;
import org.smart.board.entity.Guestbook;

import java.util.List;
import java.util.Map;

@Mapper // alt+enter
public interface GuestbookDao {
    public List<Guestbook> findAll();
    public int insert(Guestbook guestbook);
    public int delete(Map<String, Object> map);
}
