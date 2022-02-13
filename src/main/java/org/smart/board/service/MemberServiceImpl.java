package org.smart.board.service;

import org.smart.board.dao.MemberDao;
import org.smart.board.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MemberDao memberDao;

    @Override
    public int insertMember(Member member) {
        String encodedPwd = passwordEncoder.encode(member.getUsrpwd());
        member.setUsrpwd(encodedPwd);

        int result = memberDao.insertMember(member);

        return result;
    }
}
