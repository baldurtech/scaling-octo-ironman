package com.baldurtech.scaling.octo.ironman;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {

    private final MemberService memberService;

    public HomeServlet() {
        this(new MemberService(new MemberDaoImpl()));
    }

    public HomeServlet(MemberService memberService) {
        super();
        this.memberService = memberService;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,IOException {

        Map dataModel = doAction(new RequestForm(request));
        response.getWriter().println(dataModel);
    }

    public Map doAction(RequestForm form) {
        Member member = new Member();
        member.setUsername(form.getString("username"));

        Member savedMember = memberService.save(member);

        Map dataModel = new HashMap();
        dataModel.put("redirectTo", "list");

        return dataModel;
    }
}
