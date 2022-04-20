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

import com.team3.dto.ReservationVO;
import com.team3.dao.MemberDAO;
import com.team3.dto.MemberVO;


@WebServlet("/Reservation.do")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String url = "reservation_process_restaurant.jsp";
		
		HttpSession session = request.getSession();
		// 만약, 세션 속성이 유지되고 있는 동안(즉, 로그인 되어 있는 상태)에는 main.jsp 페이지로 이동한다.				
		if (session.getAttribute("loginUser") != null) {
			url = "reservation_process_restaurant.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		// post 방식 한글 처리
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();		
		
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");		
		
		//MemberDAO mDao = new MemberDAO();
		MemberDAO mDao = MemberDAO.getInstance();		

		// 포워딩 방식으로 페이지 이동
		String url = "member/login.jsp";	

		int result = mDao.checkUser(userid, pwd);
				
		if (result == 1) {
			// DB에서 회원정보(이름 포함)을 가져와서 저장하는 구문 작성
			MemberVO mVo = mDao.getMember(userid);
//			System.out.println(mVo.getUserid());
			
			HttpSession session = request.getSession();	// 세션 객체 생성
			session.setAttribute("loginUser", mVo);		// 회원 정보를 세션에 저장
			
			request.setAttribute("message", "인증이 완료되었습니다.");
			url = "main.jsp";
		} else if (result == 0) {
			
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
		} else {
			
			request.setAttribute("message", "존재하지 않는 회원입니다.");
		}	
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
		
		ReservationVO rVo = new ReservationVO();
		
		
		
		
		
	}

}
