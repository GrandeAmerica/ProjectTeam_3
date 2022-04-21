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

@WebServlet("/B_loginServlet")
public class B_loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String b_id = request.getParameter("member_b_id");
		String b_pwd = request.getParameter("member_b_pwd");
		
		MemberDAO mDao = MemberDAO.getInstance();
		
		int result = mDao.b_sign_in(b_id, b_pwd);		
		
		out.print("<html>");
		out.print("<body>");
		
		if (result == 1) {
			//DB에서 회원정보(이름 포함)을 가져와서 저장하는 구문 작성
			B_userVO bvo = mDao.b_profile(b_id);
			
			HttpSession session = request.getSession();	//세션 객체 생성
			session.setAttribute("b_profile", bvo);		//회원 정보를 세션에 저장
			
			session.setAttribute("login", "2");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		} else {
			out.print("<script>");
			out.print("alert(\"아이디 또는 패스워드가 일치하지 않습니다.\");");
			out.print("location.href=\"member/login.jsp\";");
			out.print("</script>");
		}
		
		out.print("</body>");
		out.print("</html>");
	}

}
