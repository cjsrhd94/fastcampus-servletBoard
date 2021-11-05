package com.fastcampus.controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastcampus.biz.user.UserDAO;
import com.fastcampus.biz.user.UserVO;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자 입력정보(id, password) 추출
		// 사용자가 입력한 파라미터 정보를 추출한다.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB 연동 처리
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
//		// 3. 응답 화면 구성
//		// 출력 스트림을 얻기 전에 응답 메시지에 대한 인코딩을 설정한다.
//		response.setContentType("text/html;charset=EUC-KR");
//
//		// Http 응답 프로토콜 Body와 연결된 출력 스트림을 얻는다.
//		PrintWriter out = response.getWriter();

		if(user != null) {
			response.sendRedirect("getBoardList.do");
		} else {
			response.sendRedirect("login.html");
		}
		
//		out.close();
	}

}






