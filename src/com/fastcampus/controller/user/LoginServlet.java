package com.fastcampus.controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
		// 1. ����� �Է�����(id, password) ����
		// ����ڰ� �Է��� �Ķ���� ������ �����Ѵ�.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB ���� ó��
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
//		// 3. ���� ȭ�� ����
//		// ��� ��Ʈ���� ��� ���� ���� �޽����� ���� ���ڵ��� �����Ѵ�.
//		response.setContentType("text/html;charset=EUC-KR");
//
//		// Http ���� �������� Body�� ����� ��� ��Ʈ���� ��´�.
//		PrintWriter out = response.getWriter();

		RequestDispatcher dispatcher = null;
		if(user != null) {
			request.setAttribute("userName", user.getName());
			dispatcher = request.getRequestDispatcher("/getBoardList.do");
//			response.sendRedirect("getBoardList.do");
		} else {
			dispatcher = request.getRequestDispatcher("/login.html");
//			response.sendRedirect("login.html");
		}
		dispatcher.forward(request,response);

//		out.close();
	}

}






