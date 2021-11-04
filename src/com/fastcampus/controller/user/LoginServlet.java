package com.fastcampus.controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastcampus.biz.user.UserDAO;
import com.fastcampus.biz.user.UserVO;

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
		
		// 3. ���� ȭ�� ����
		// ��� ��Ʈ���� ��� ���� ���� �޽����� ���� ���ڵ��� �����Ѵ�. 
		response.setContentType("text/html;charset=EUC-KR");
		
		// Http ���� �������� Body�� ����� ��� ��Ʈ���� ��´�.
		PrintWriter out = response.getWriter();

		if(user != null) {
			out.println("<h1>�α��� ����</h1>");
		} else {
			out.println("<h1>�α��� ����</h1>");
		}
		
		out.close();
	}

}






