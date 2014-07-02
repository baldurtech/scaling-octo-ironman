package com.baldurtech.scaling.octo.ironman;

public class MemberDaoImpl implements MemberDao {
    public Member save(Member member) {
        System.out.println("MemberDao.save: " + member);
        member.setId(new java.util.Date().getTime());
        return member;
    }
}
