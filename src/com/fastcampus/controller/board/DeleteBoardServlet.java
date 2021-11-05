package com.fastcampus.controller.board;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastcampus.biz.board.BoardDAO;
import com.fastcampus.biz.board.BoardVO;

@WebServlet(urlPatterns = "/deleteBoard.do")
public class DeleteBoardServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. ����� �Է����� ����
		String seq = request.getParameter("seq");
		
		// 2. DB ���� ó��
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.deleteBoard(vo);
		
		// 3. ȭ�� �׺���̼�
		RequestDispatcher dispatcher = request.getRequestDispatcher("/getBoardList.do");
		dispatcher.forward(request, response);
//		response.sendRedirect("getBoardList.do");
	}

}
