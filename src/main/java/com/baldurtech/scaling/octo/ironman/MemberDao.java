package com.baldurtech.scaling.octo.ironman;

public interface MemberDao {
    public Member getById(Long id);
    public Member save(Member member);
    public Member update(Member member);
}
