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

class MockRequestForm extends RequestForm {
    Map data = new HashMap();

    public MockRequestForm() {
        super(null);
    }

    public void set(String param, String value) {
        data.put(param, value);
    }

    public String getString(String param) {
        return (String) data.get(param);
    }
}
