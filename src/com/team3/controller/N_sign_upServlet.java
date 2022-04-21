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
import com.team3.dto.N_userVO;

@WebServlet("/N_sign_upServlet")
public class N_sign_upServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/n_sign_up.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		String user_id = request.getParameter("user_id");
		String user_password = request.getParameter("member_n_pwd");
		String user_name = request.getParameter("member_n_name");
		String user_email = request.getParameter("member_n_email");
		String user_tel = request.getParameter("member_n_tel");
		
		MemberDAO mDao = MemberDAO.getInstance();
		N_userVO mVo = new N_userVO();
		
		mVo.setUser_id(user_id);
		mVo.setUser_password(user_password);
		mVo.setUser_name(user_name);
		mVo.setUser_email(user_email);
		mVo.setUser_tel(user_tel);
		
		int result = mDao.n_sign_up(mVo);
		
		out.print("<html>");
		out.print("<body>");
		
		if(result == 1) {	//회원 가입 성공 - DB에 성공적으로 저장 완료 되었는가
			System.out.println("회원가입에 성공 하였습니다.");
			
			out.print("<script>");
			out.print("alert(\"회원가입에 성공 하였습니다.\");");
			out.print("location.href=\"member/login.jsp\";");
			out.print("</script>");

		} else {	//회원 가입 실패 - DB에 저장 실패 하였는가
			System.out.println("회원가입에 실패 하였습니다.");

			out.print("<script>");
			out.print("alert(\"회원가입에 실패 하였습니다.\");");
			out.print("location.href=\"N_sign_upServlet\";");
			out.print("</script>");
			
		}
		
		out.print("</body>");
		out.print("</html>");
	}

}
