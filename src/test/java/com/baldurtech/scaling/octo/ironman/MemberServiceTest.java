package com.baldurtech.scaling.octo.ironman;

import com.baldurtech.unit.MiniatureSpiceTestCase;

public class MemberServiceTest extends MiniatureSpiceTestCase {
    MockMemberDao memberDao = new MockMemberDao();
    MemberService memberService = new MemberService(memberDao);

    public void test_valid_member_should_be_saved() {
        memberService.save(createMemberWithUsername("Tom"));

        assertTrue(memberDao.saveHasInvoked);
    }

    public void test_username_is_empty_should_not_save() {
        memberService.save(createMemberWithUsername(""));

        assertFalse(memberDao.saveHasInvoked);
    }

    public void test_username_is_blank_should_not_save() {
        memberService.save(createMemberWithUsername("   "));

        assertFalse(memberDao.saveHasInvoked);
    }

    private Member createMemberWithUsername(String username) {
        Member member = new Member();
        member.setUsername(username);

        return member;
    }
}

class MockMemberDao implements MemberDao {
    public Boolean saveHasInvoked = false;

    public Member save(Member member) {
        saveHasInvoked = true;
        return member;
    }
}
