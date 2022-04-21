package com.team3.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team3.dao.MemberDAO;
import com.team3.dto.B_userVO;


@WebServlet("/B_deleteIdServlet")
public class B_deleteIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/b_deleteId.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String user_id = ((B_userVO) session.getAttribute("b_profile")).getUser_id();
		String member_b_pwd = request.getParameter("member_b_pwd");
		
		MemberDAO mDao = MemberDAO.getInstance();
		B_userVO bvo = new B_userVO();
		
		if(member_b_pwd.equals(((B_userVO) session.getAttribute("b_profile")).getUser_password())) {
			bvo.setUser_id(user_id);
			
			int result = mDao.b_user_delete(bvo);
			
			session.invalidate();

			out.print("<html>");
			out.print("<body>");
			
			out.print("<script>");
			out.print("alert(\"회원탈퇴 되었습니다.\");");
			out.print("location.href=\"index.jsp\";");
			out.print("</script>");
			
			out.print("</body>");
			out.print("</html>");
		} else {
			out.print("<html>");
			out.print("<body>");
			
			out.print("<script>");
			out.print("alert(\"실패 하였습니다.\");");
			out.print("location.href=\"member/b_secession.jsp\";");
			out.print("</script>");
			
			out.print("</body>");
			out.print("</html>");
		}
		
		
	}

}
