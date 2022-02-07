package org.smart.board.dao;

import org.apache.ibatis.annotations.Mapper;
import org.smart.board.entity.Guestbook;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;
import java.util.Map;

@Mapper
public interface GuestbookDao {
    public List<Guestbook> findAll();
    public int insert(Guestbook guestbook);
    public int delete(Map<String,Object> map);
}
