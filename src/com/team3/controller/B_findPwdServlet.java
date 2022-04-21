package com.team3.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team3.dao.MemberDAO;

@WebServlet("/B_findPwdServlet")
public class B_findPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("member_b_id");
		
		MemberDAO mDao = MemberDAO.getInstance();
		
		int result = mDao.confirmID(user_id);
		
		out.print("<html>");
		out.print("<body>");
		
		if (user_id==null || user_id=="") {
			out.print("<script>");
			out.print("alert(\"아이디를 입력 해 주세요.\");");
			out.print("location.href=\"member/findpwd.jsp\";");
			out.print("</script>");
			
		} else {
			if (result == 1) {
				request.setAttribute("user_id", user_id);
				RequestDispatcher dispatcher = request.getRequestDispatcher("member/b_newPwd.jsp");
				dispatcher.forward(request, response);
			} else if (result == -1) {
				out.print("<script>");
				out.print("alert(\"정보가 없는 회원 입니다.\");");
				out.print("location.href=\"member/findpwd.jsp\";");
				out.print("</script>");
			}
		}
		
		out.print("</body>");
		out.print("</html>");
		
	}

}
