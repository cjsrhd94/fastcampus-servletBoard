package com.fastcampus.controller.board;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastcampus.biz.board.BoardDAO;
import com.fastcampus.biz.board.BoardVO;
@WebServlet(urlPatterns = "/updateBoard.do",
		initParams = @WebInitParam(name = "encoding", value = "EUC-KR"))
public class UpdateBoardServlet extends HttpServlet {

	private String boardEncoding;

	@Override
	public void init(ServletConfig config) throws ServletException {
		boardEncoding = config.getInitParameter("encoding");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자 입력정보 추출
		request.setCharacterEncoding(boardEncoding);
		String seq = request.getParameter("seq");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		vo.setTitle(title);
		vo.setContent(content);
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.updateBoard(vo);
		
		// 3. 화면 네비게이션
		RequestDispatcher dispatcher = request.getRequestDispatcher("/getBoardList.do");
		dispatcher.forward(request, response);
//		response.sendRedirect("getBoardList.do");
	}

}
