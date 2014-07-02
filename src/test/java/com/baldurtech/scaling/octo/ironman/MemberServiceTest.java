package com.baldurtech.scaling.octo.ironman;

import com.baldurtech.unit.MiniatureSpiceTestCase;

public class MemberServiceTest extends MiniatureSpiceTestCase {
    MockMemberDao memberDao = new MockMemberDao();
    MemberService memberService = new MemberService(memberDao);

    public void test_valid_member_should_be_saved() {
        memberService.save(createMemberWithUsername("Tom"));

        assertTrue(memberDao.saveHasInvoked);
    }

    public void test_username_should_be_trimed() {
        memberService.save(createMemberWithUsername("  Jack  "));

        assertEquals("Jack", memberDao.savedMember.getUsername());
    }

    public void test_username_is_empty_should_not_save() {
        memberService.save(createMemberWithUsername(""));

        assertFalse(memberDao.saveHasInvoked);
    }

    public void test_username_is_blank_should_not_save() {
        memberService.save(createMemberWithUsername("   "));

        assertFalse(memberDao.saveHasInvoked);
    }

    public void test_更新一个已经存在的member() {
        memberDao.expectedMember =
            createMemberWithIdAndUsername(1999L, "JJ");


        Member member = createMemberWithUsername("Hanks");
        member.setId(1999L);

        memberService.update(member);


        assertEquals("Hanks",
                     memberDao.updatedMember.getUsername());
        assertEquals(1999L, memberDao.updatedMember.getId());
    }

    private Member createMemberWithUsername(String username) {
        Member member = new Member();
        member.setUsername(username);

        return member;
    }

    private Member createMemberWithIdAndUsername(Long id, String username) {
        Member member = createMemberWithUsername(username);
        member.setId(id);
        return member;
    }
}

class MockMemberDao implements MemberDao {
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
