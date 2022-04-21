package com.team3.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team3.dao.MemberDAO;

@WebServlet("/IdCheckServlet")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		
		MemberDAO mDao = MemberDAO.getInstance();
		
		int result = mDao.confirmID(user_id);
		
		if (user_id==null || user_id=="") {
			request.setAttribute("message", "사용하실 아이디를 입력해 주세요.");
		} else {
			if (result == 1) {
				request.setAttribute("message", "이미 사용중인 아이디 입니다.");
				request.setAttribute("result", "1");
			} else if (result == -1) {
				request.setAttribute("message", "사용 가능한 아이디 입니다.");
				request.setAttribute("result", "-1");
				request.setAttribute("user_id", user_id);
			}
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/idCheck.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
