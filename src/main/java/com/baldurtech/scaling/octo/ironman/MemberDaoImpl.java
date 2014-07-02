package com.baldurtech.scaling.octo.ironman;

public class MemberDaoImpl implements MemberDao {

    public Member getById(Long id) {
        System.out.println("MemberDao.getById: " + id);
        Member member = new Member();
        long timestamp = new java.util.Date().getTime();
        member.setUsername("u" + timestamp);
        member.setId(timestamp);
        return member;
    }

    public Member save(Member member) {
        System.out.println("MemberDao.save: " + member);
        member.setId(new java.util.Date().getTime());
        return member;
    }

    public Member update(Member member) {
        System.out.println("MemberDao.update: " + member);
        return member;
    }
}
