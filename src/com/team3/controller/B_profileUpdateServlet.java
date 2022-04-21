package com.team3.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team3.dao.MemberDAO;
import com.team3.dto.B_userVO;

@WebServlet("/B_profileUpdateServlet")
public class B_profileUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		String user_id = request.getParameter("user_id");
		String member_b_pwd = request.getParameter("member_b_pwd");
		String user_name = request.getParameter("member_b_name");
		String user_email = null;
		String member_b_newemail = request.getParameter("member_b_newemail");
		String user_tel = request.getParameter("member_b_tel");
		String b_license = ((B_userVO) session.getAttribute("b_profile")).getB_license();
		
		System.out.println(b_license);
		
		MemberDAO mDao = MemberDAO.getInstance();
		B_userVO bvo = new B_userVO();
		
		if(member_b_pwd.equals("")||member_b_pwd.equals(null)) {
			member_b_pwd = ((B_userVO) session.getAttribute("b_profile")).getUser_password();
		}
		
		if(member_b_newemail.equals("") || member_b_newemail.equals(null)) {
			user_email = request.getParameter("member_b_email");
		}else {
			user_email = request.getParameter("member_b_newemail");
		}
		
		bvo.setUser_id(user_id);
		bvo.setUser_password(member_b_pwd);
		bvo.setUser_name(user_name);
		bvo.setUser_email(user_email);
		bvo.setUser_tel(user_tel);
		bvo.setB_license(b_license);
		
		System.out.println(bvo);
		int result = mDao.b_profile_update(bvo);
		
		out.print("<html>");
		out.print("<body>");
		
		if(result == 1) {	//회원 가입 성공 - DB에 성공적으로 저장 완료 되었는가
			System.out.println("성공 하였습니다.");
			
			session.setAttribute("b_profile", bvo);
			
			out.print("<script>");
			out.print("alert(\"성공 하였습니다.\");");
			out.print("location.href=\"ProfileServlet\";");
			out.print("</script>");

		} else {	//회원 가입 실패 - DB에 저장 실패 하였는가
			System.out.println("실패 하였습니다.");

			out.print("<script>");
			out.print("alert(\"실패 하였습니다.\");");
			out.print("location.href=\"ProfileServlet\";");
			out.print("</script>");
			
		}
		
		out.print("</body>");
		out.print("</html>");
	}

}
