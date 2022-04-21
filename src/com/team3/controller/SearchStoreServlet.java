package com.team3.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team3.dao.StoreDAO;
import com.team3.dto.StoreVO;

@WebServlet("/searchStore.do")
public class SearchStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		StoreDAO sDao = StoreDAO.getInstance();
		StoreVO sVO = new StoreVO();
		
		String query = request.getParameter("query");
		System.out.println(query);
		
		List<StoreVO> searchStore = sDao.searchStore(query);
		request.setAttribute("searchStore", searchStore);
		System.out.println("2212");
		RequestDispatcher dispatcher = request.getRequestDispatcher("store/storeList.jsp");
		dispatcher.forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
