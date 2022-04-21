package com.team3.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team3.dao.MemberDAO;
import com.team3.dao.ReservationDAO;
import com.team3.dto.MemberVO;
import com.team3.dto.ReservationVO;


@WebServlet("/Reservation.do")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "reservation_process_restaurant.jsp";

		HttpSession session = request.getSession();
		// 만약, 세션 속성이 유지되고 있는 동안(즉, 로그인 되어 있는 상태)에는 main.jsp 페이지로 이동한다.				
		if (session.getAttribute("loginUser") != null) {
			url = "reser_request_restaurant.jsp";
			url = "reser_request_lodging.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		// post 방식 한글 처리
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();		
		
		ReservationVO rVo = new ReservationVO();
	
		try {
		
			String user_id = request.getParameter("user_id");
			
			String resr_user_name = request.getParameter("resr_user_name");
			String resr_store_name = request.getParameter("resr_store_name");
			Date resr_date = Date.valueOf(request.getParameter("resr_date"));
			Date resr_time = Date.valueOf(request.getParameter("resr_time"));
			String resr_store_need = request.getParameter("resr_store_need");
			Date resr_usingtime = Date.valueOf(request.getParameter("resr_usingtime"));
			int resr_person = Integer.parseInt(request.getParameter("resr_person"));
			String resr_info = request.getParameter("resr_info");
			String resr_before_info = request.getParameter("resr_before_info");
			
			System.out.println("user_id");
			System.out.println("resr_number");
			System.out.println("resr_user_name");
			System.out.println("resr_store_name");
			System.out.println("resr_date");
			System.out.println("resr_time");
			System.out.println("resr_store_need");
			System.out.println("resr_usingtime");
			System.out.println("resr_person");
			System.out.println("resr_info");
			System.out.println("resr_before_info");
			
			rVo.setUser_id(user_id);
			
			rVo.setResr_user_name(resr_user_name);
			rVo.setResr_store_name(resr_store_name);
			rVo.setResr_date(resr_date);
			rVo.setResr_time(resr_time);
			rVo.setResr_store_need(resr_store_need);
			rVo.setResr_usingtime(resr_usingtime);
			rVo.setResr_person(resr_person);
			rVo.setResr_info(resr_info);
			rVo.setResr_before_info(resr_before_info);

		} catch(Exception e) {
			System.out.println("예외 발생 : " + e);
		}
		
	
		ReservationDAO rDao = ReservationDAO.getInstance();
		
		int result = rDao.insertReservation(rVo);
		
		if (result == 1) {
			System.out.println("예약 등록에 성공했습니다.");
			request.setAttribute("message", "예약 등록에 성공했습니다.");
		} else {
			System.out.println("예약 등록에 실패했습니다.");
			request.setAttribute("message", "예약 등록에 실패했습니다.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("payment_process_restaurant.jsp");
		dispatcher.forward(request, response);
		
	}
	

}
