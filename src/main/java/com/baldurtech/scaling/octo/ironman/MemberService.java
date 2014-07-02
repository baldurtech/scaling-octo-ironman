package com.baldurtech.scaling.octo.ironman;

public class MemberService {

    private final MemberDao memberDao;

    public MemberService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public Member save(Member member) {
        if(member.getUsername() != null && member.getUsername().length() > 0) {
            return memberDao.save(member);
        }
        return member;
    }
}
