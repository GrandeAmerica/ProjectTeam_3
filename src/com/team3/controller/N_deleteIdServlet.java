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


@WebServlet("/N_deleteIdServlet")
public class N_deleteIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/n_deleteId.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String user_id = ((N_userVO) session.getAttribute("n_profile")).getUser_id();
		String member_n_pwd = request.getParameter("member_n_pwd");
		
		MemberDAO mDao = MemberDAO.getInstance();
		N_userVO nvo = new N_userVO();
		
		if(member_n_pwd.equals(((N_userVO) session.getAttribute("n_profile")).getUser_password())) {
			nvo.setUser_id(user_id);
			
			int result = mDao.n_user_delete(nvo);
			
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
			out.print("location.href=\"member/n_secession.jsp\";");
			out.print("</script>");
			
			out.print("</body>");
			out.print("</html>");
		}
		
		
	}

}
