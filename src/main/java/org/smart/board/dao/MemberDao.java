package org.smart.board.dao;

import org.apache.ibatis.annotations.Mapper;
import org.smart.board.entity.Member;

@Mapper
public interface MemberDao {
    // 회원가입
    public int insertMember(Member member);
}
