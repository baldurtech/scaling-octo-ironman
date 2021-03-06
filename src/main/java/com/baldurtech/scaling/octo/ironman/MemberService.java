package com.baldurtech.scaling.octo.ironman;

public class MemberService {

    private final MemberDao memberDao;

    public MemberService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public Member save(Member member) {
        if(member.getUsername() != null && member.getUsername().trim().length() > 0) {
            Member memberWillBeSaved = new Member();
            memberWillBeSaved.setUsername(member.getUsername().trim());
            return memberDao.save(memberWillBeSaved);
        }
        return member;
    }

    public Member update(Member member) {
        Member origMember = memberDao.getById(member.getId());
        if(origMember != null) {
            origMember.setUsername(member.getUsername());
            return memberDao.update(origMember);
        }
        return member;
    }
}
