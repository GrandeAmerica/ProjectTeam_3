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
import com.team3.dto.N_userVO;

@WebServlet("/N_loginServlet")
public class N_loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String n_id = request.getParameter("member_n_id");
		String n_pwd = request.getParameter("member_n_pwd");
		
		MemberDAO mDao = MemberDAO.getInstance();
		
		int result = mDao.n_sign_in(n_id, n_pwd);
		
		out.print("<html>");
		out.print("<body>");
		
		if (result == 1) {
			//DB에서 회원정보(이름 포함)을 가져와서 저장하는 구문 작성
			N_userVO nvo = mDao.n_profile(n_id);
			
			HttpSession session = request.getSession();	//세션 객체 생성
			session.setAttribute("n_profile", nvo);		//회원 정보를 세션에 저장
			
			session.setAttribute("login", "1");
			
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
