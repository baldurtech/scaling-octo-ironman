package com.baldurtech.scaling.octo.ironman;

public class MockMemberService extends MemberService {
    public Member saveShouldReturnMember;

    public MockMemberService() {
        super(null);
    }

    public Member save(Member member) {
        return saveShouldReturnMember;
    }
}
