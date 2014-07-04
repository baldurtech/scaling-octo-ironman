package com.baldurtech.scaling.octo.ironman;

public class MockMemberDao implements MemberDao {
    public Boolean saveHasInvoked = false;
    public Member savedMember;
    public Member expectedMember;
    public Boolean updateHasInvoked = false;
    public Member updatedMember;

    public Member getById(Long id) {
        return expectedMember;
    }

    public Member save(Member member) {
        savedMember = member;
        saveHasInvoked = true;
        return member;
    }

    public Member update(Member member) {
        updatedMember = member;
        updateHasInvoked = true;
        return member;
    }
}
