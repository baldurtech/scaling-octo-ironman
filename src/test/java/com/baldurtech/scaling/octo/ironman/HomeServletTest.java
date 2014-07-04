package com.baldurtech.scaling.octo.ironman;

import com.baldurtech.unit.MiniatureSpiceTestCase;
import java.util.Map;
import java.util.HashMap;

public class HomeServletTest extends MiniatureSpiceTestCase {
    public void test_member保存成功后要返回list页面() {
        Member expectedMember = new Member();
        expectedMember.setUsername("Tom");
        expectedMember.setId(1L);

        MockMemberService memberService = new MockMemberService();
        memberService.saveShouldReturnMember = expectedMember;
        MockRequestForm form = new MockRequestForm();
        form.set("action", "save");

        HomeServlet homeServlet = new HomeServlet(memberService);

        Map dataModel = homeServlet.doAction(form);

        assertEquals("list", dataModel.get("redirectTo"));
    }

    public void test_member保存失败后要返回编辑页面() {
        Member expectedMember = new Member();
        expectedMember.setUsername(" Tom ");

        MockMemberService memberService = new MockMemberService();
        memberService.saveShouldReturnMember = expectedMember;
        MockRequestForm form = new MockRequestForm();
        form.set("action", "save");

        HomeServlet homeServlet = new HomeServlet(memberService);

        Map dataModel = homeServlet.doAction(form);

        assertEquals("edit", dataModel.get("forward"));
        assertEquals(expectedMember, dataModel.get("member"));
    }
}

class MockMemberService extends MemberService {
    public Member saveShouldReturnMember;

    public MockMemberService() {
        super(null);
    }

    public Member save(Member member) {
        return saveShouldReturnMember;
    }
}
