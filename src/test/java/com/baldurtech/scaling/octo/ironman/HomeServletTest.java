package com.baldurtech.scaling.octo.ironman;

import java.util.Map;
import java.util.HashMap;

public class HomeServletTest extends ScalingOctoIronmanTestCase {
    MockRequestForm form = new MockRequestForm();
    MockMemberService memberService = new MockMemberService();
    HomeServlet homeServlet = new HomeServlet(memberService);

    public void test_member保存成功后要返回list页面() {
        Member expectedMember = createMemberWithIdAndUsername(1L, "Tom");
        memberService.saveShouldReturnMember = expectedMember;
        form.set("action", "save");


        Map dataModel = homeServlet.doAction(form);


        assertEquals("list", dataModel.get("redirectTo"));
    }

    public void test_member保存失败后要返回编辑页面() {
        Member expectedMember = createMemberWithUsername(" Tom ");
        memberService.saveShouldReturnMember = expectedMember;
        form.set("action", "save");


        Map dataModel = homeServlet.doAction(form);


        assertEquals("edit", dataModel.get("forward"));
        assertEquals(expectedMember, dataModel.get("member"));
    }

    public void test_保存member的时候使用GET方法要失败() {
        form.useGetMethod();


        Map dataModel = homeServlet.doAction(form);


        assertEquals(403, (int)dataModel.get("statusCode"));
    }
}
