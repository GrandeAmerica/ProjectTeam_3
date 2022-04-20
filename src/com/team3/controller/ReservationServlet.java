package com.team3.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
			url = "reservation_process_restaurant.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		// post 방식 한글 처리
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();		
		
		ReservationVO rVo = new ReservationVO();
		
		ServletContext context = getServletContext();
		
		String encType = "UTF-8";
		
		
		try {
			MultipartRequest multi = new MultipartRequest(request, encType, 0, new DefaultFileRenamePolicy());
			
			String name = multi.getParameter("name");
			int price = Integer.parseInt(multi.getParameter("price"));
			String pictureurl = multi.getFilesystemName("pictureurl");
			String description = multi.getParameter("description");

//			rVo.setName(name);
//			rVo.setPrice(price);
//			rVo.setPictureurl(pictureurl);
//			rVo.setDescription(description);

		} catch(Exception e) {
			System.out.println("예외 발생 : " + e);
		}
		
		
		
		ReservationDAO rDao = ReservationDAO.getInstance();
		
		int result = rDao.insertReservation(rVo);
		
		if (result == 1) {
			System.out.println("상품 등록에 성공했습니다.");
			request.setAttribute("message", "상품 등록에 성공했습니다.");
		} else {
			System.out.println("상품 등록에 실패했습니다.");
			request.setAttribute("message", "상품 등록에 실패했습니다.");
		}
		
		response.sendRedirect("productList.do");
		
	}
	

}
