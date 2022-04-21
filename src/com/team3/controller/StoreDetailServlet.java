package com.team3.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team3.dao.StoreDAO;
import com.team3.dto.StoreVO;

@WebServlet("/storeDetail.do")
public class StoreDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		//상품 이름 가져와서 조회한 내용 출력
		String store_name = request.getParameter("store_name");
		
		StoreDAO sDao = StoreDAO.getInstance();
		StoreVO sVo = new StoreVO();
		
		sVo = sDao.StoreDetail(store_name);
		
		request.setAttribute("store", sVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("store/storeDetail.jsp");
		dispatcher.forward(request, response);
	}
}