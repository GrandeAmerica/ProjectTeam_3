package com.team3.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team3.dao.MemberDAO;
import com.team3.dto.B_userVO;

@WebServlet("/B_findIdServlet")
public class B_findIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		String user_email = request.getParameter("member_b_email");

		MemberDAO mDao = MemberDAO.getInstance();
		
		B_userVO nvo = mDao.b_findIdEmail(user_email);
		
		out.print("<html>");
		out.print("<body>");
		
		if (nvo.getUser_id()==null) {
			out.print("<script>");
			out.print("alert(\"실패 하였습니다.\");");
			out.print("location.href=\"member/findid.jsp\";");
			out.print("</script>");
		} else if (nvo.getUser_id()==nvo.getUser_id()) {
			System.out.println(nvo.getUser_id());
			out.print("<script>");
			out.print("alert(\"성공 하였습니다.\");");
			out.print("location.href=\"member/login.jsp\";");
			out.print("</script>");
		}
		
		out.print("</body>");
		out.print("</html>");
	}

}
