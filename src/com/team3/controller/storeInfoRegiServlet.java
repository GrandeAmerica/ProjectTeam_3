package com.team3.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team3.dao.StoreDAO;
import com.team3.dto.StoreVO;

@WebServlet("/storeInfoRegi.do")
public class storeInfoRegiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*		
		StoreDAO pDao = StoreDAO.getInstance();
		List<StoreVO> productList = pDao.selectProduct();
		request.setAttribute("StoreList", StoreList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("store_info_mng.jsp");
		dispatcher.forward(request, response);
*/		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("store_info => doPost");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;  charset=utf-8");
		//PrintWriter out = response.getWriter();
		
		//UploadDTO dto = new UploadDTO();
		
		String savePath = "images";
		int uploadFileSizeLimit = 5 * 1024 * 1024;
		String encType = "UTF-8";
		
		
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
	    System.out.println("서버상의 실제 디렉토리:");
	    System.out.println(uploadFilePath);
		
	    
		MultipartRequest multi = new MultipartRequest(request, 
				uploadFilePath,
				uploadFileSizeLimit,
				encType,
				new DefaultFileRenamePolicy());
		
		String Dir = "D:/billyyun/work/jsp__work/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/test-project3/images/"; 
		
		String userid = "btestid01"; //request.getParameter("b_userid");
		
		String fileName1 = multi.getFilesystemName("store_img_file_name1");  //1 대표사진1 위치경로 정보
	    String realFileName1 = userid + "_" + fileName1;  //현재시간과 확장자 합치기
		Path source1 = Paths.get(Dir + fileName1);
		try{
		    // rename a file in the same directory
			Files.move(source1, source1.resolveSibling(realFileName1),StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
		    e.printStackTrace();
		}		
	    
	   
		String fileName2 = multi.getFilesystemName("store_img_file_name2");  //1 대표사진2 위치경로 정보
	    String realFileName2 = userid + "_" + fileName2;  //현재시간과 확장자 합치기
		Path source2 = Paths.get(Dir + fileName2);
		try{
		    // rename a file in the same directory
			Files.move(source2, source2.resolveSibling(realFileName2),StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
		    e.printStackTrace();
		}	
		
		
		String fileName3 = multi.getFilesystemName("store_img_file_name3");  //1 대표사진3 위치경로 정보
	    String realFileName3 = userid + "_" + fileName3;  //현재시간과 확장자 합치기
		Path source3 = Paths.get(Dir + fileName3);
		try{
		    // rename a file in the same directory
			Files.move(source3, source3.resolveSibling(realFileName3),StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
		    e.printStackTrace();
		}	

		String store_name = multi.getParameter("store_name");        		   //2 업체 이름
		String store_type = multi.getParameter("store_type");				   //3 업종 선택
		String time_day = multi.getParameter("time_day");					   //4 운영 시간 - 평일
		String time_week = multi.getParameter("time_week");					   //5 운영 시간 - 주말
		String store_addr = multi.getParameter("store_addr");				   //6 주소	
		String store_addr_detail = multi.getParameter("store_addr_detail");	   //7 주소 상세
		String store_tel = multi.getParameter("store_tel");			           //8 업체 전화
		//String menu_info = multi.getParameter("menu_info");			           //9 메뉴와 가격
		String store_parking = multi.getParameter("store_parking");			   //9 주차 여부
		String store_parking_etc = multi.getParameter("store_parking_etc");	   //10 주차 여부 - 비고
		System.out.println("multi => userid => " + userid);
		System.out.println("multi => store_img_file_name1 => " + realFileName1);
		System.out.println("multi => store_img_file_name2 => " + realFileName2);
		System.out.println("multi => store_img_file_name3 => " + realFileName3);
		System.out.println("multi => store_name => " + store_name);
		System.out.println("multi => store_type => " + store_type);
		System.out.println("multi => time_day => " + time_day);
		System.out.println("multi => time_week => " + time_week);
		System.out.println("multi => store_addr => " + store_addr);
		System.out.println("multi => store_addr_detail => " + store_addr_detail);
		System.out.println("multi => store_tel => " + store_tel);
		//System.out.println("multi => menu_info => " + menu_info);
		System.out.println("multi => store_parking => " + store_parking);
		System.out.println("multi => store_parking_etc => " + store_parking_etc);

		
		
		StoreDAO sDao = new StoreDAO();
		StoreVO sVo = new StoreVO(); 
		
		sVo.setUserid(userid);
		sVo.setStore_photo1(realFileName1);
		sVo.setStore_photo2(realFileName2);
		sVo.setStore_photo3(realFileName3);
		sVo.setStore_name(store_name);
		sVo.setStore_type(store_type);
		sVo.setStore_time(time_day);
		sVo.setStore_time_w(time_week);
		sVo.setStore_addr(store_addr);
		sVo.setStore_addr_detail(store_addr_detail);
		sVo.setStore_tel(store_tel);
		//sVo.setMenu_info(menu_info);
		sVo.setParking(store_parking);
		sVo.setParking_detail(store_parking_etc);
		
		int result =  sDao.insertStoreInfo(sVo);

		if(result == 1) {
			System.out.println("insertStoreInfo's result(등록 성공) : " + result);
			
			request.setAttribute("fileName1", fileName1);
			request.setAttribute("fileName2", fileName2);
			request.setAttribute("fileName3", fileName3);
			request.setAttribute("realFileName1", realFileName1);
			request.setAttribute("realFileName2", realFileName2);
			request.setAttribute("realFileName3", realFileName3);
			request.setAttribute("store_name", store_name);
			request.setAttribute("store_type", store_type);
			request.setAttribute("time_day", time_day);
			request.setAttribute("time_week", time_week);
			request.setAttribute("store_addr", store_addr);
			request.setAttribute("store_addr_detail", store_addr_detail);
			request.setAttribute("store_tel", store_tel);
			request.setAttribute("store_parking", store_parking);
			request.setAttribute("store_parking_etc", store_parking_etc);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("store_info_mng.jsp");
			//RequestDispatcher dispatcher = request.getRequestDispatcher("store_info_mng.do");
			dispatcher.forward(request, response);
		}else{
			System.out.println("insertStoreInfo's result(등록 실퍠) : " + result);
			RequestDispatcher dispatcher = request.getRequestDispatcher("store_info_regi.jsp");
			dispatcher.forward(request, response);
		}

	}

}
