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
import com.team3.dto.N_userVO;

@WebServlet("/N_profileUpdateServlet")
public class N_profileUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		String user_id = request.getParameter("user_id");
		String member_n_pwd = request.getParameter("member_n_pwd");
		String user_name = request.getParameter("member_n_name");
		String user_email = null;
		String member_n_newemail = request.getParameter("member_n_newemail");
		String user_tel = request.getParameter("member_n_tel");
		int n_membership = ((N_userVO) session.getAttribute("n_profile")).getN_membership();
		
		MemberDAO mDao = MemberDAO.getInstance();
		N_userVO nvo = new N_userVO();
		
		if(member_n_pwd.equals("")||member_n_pwd.equals(null)) {
			member_n_pwd = ((N_userVO) session.getAttribute("n_profile")).getUser_password();
		}
		
		if(member_n_newemail.equals("") || member_n_newemail.equals(null)) {
			user_email = request.getParameter("member_n_email");
		}else {
			user_email = request.getParameter("member_n_newemail");
		}
		
		nvo.setUser_id(user_id);
		nvo.setUser_password(member_n_pwd);
		nvo.setUser_name(user_name);
		nvo.setUser_email(user_email);
		nvo.setUser_tel(user_tel);
		nvo.setN_membership(n_membership);
		
		int result = mDao.n_profile_update(nvo);
		
		out.print("<html>");
		out.print("<body>");
		
		if(result == 1) {	//회원 가입 성공 - DB에 성공적으로 저장 완료 되었는가
			System.out.println("성공 하였습니다.");
			
			session.setAttribute("n_profile", nvo);
			
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
