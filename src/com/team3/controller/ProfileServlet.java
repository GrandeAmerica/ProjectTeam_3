package com.team3.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team3.dto.N_userVO;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		
		String profile = "";
		
		if(session.getAttribute("login") == "1") {
			
			if (  ((N_userVO) session.getAttribute("n_profile")).getN_membership() == 0  ) {
				request.setAttribute("n_membership", "블랙리스트");
			} else if (  ((N_userVO) session.getAttribute("n_profile")).getN_membership() == 1  ) {
				request.setAttribute("n_membership", "일반회원");
			} else if (  ((N_userVO) session.getAttribute("n_profile")).getN_membership() == 2  ) {
				request.setAttribute("n_membership", "vip");
			}
			
			profile = "member/n_profile.jsp";
		} else if(session.getAttribute("login") == "2") {
			profile = "member/b_profile.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(profile);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
