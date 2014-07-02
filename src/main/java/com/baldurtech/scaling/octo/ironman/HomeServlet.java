package com.baldurtech.scaling.octo.ironman;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,IOException {
        MemberDao memberDao = new MemberDaoImpl();

        Member member = new Member();
        member.setUsername(request.getParameter("username"));

        MemberService memberService = new MemberService(memberDao);
        memberService.save(member);

        response.getWriter().println("Member: " + member);
    }
}
