package com.fastcampus.controller.board;

import com.fastcampus.biz.board.BoardDAO;
import com.fastcampus.biz.board.BoardVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/insertBoard.do")
public class InsertBoardServlet extends HttpServlet {

    private String boardEncoding;

//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        boardEncoding = config.getInitParameter("encoding");
//    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 사용자 입력정보 추출
        // 사용자가 입력한 데이터에 포함된 한글을 인코딩한다.
        ServletContext context = getServletContext();
        boardEncoding = context.getInitParameter("encoding");

        request.setCharacterEncoding(boardEncoding);
        String title = request.getParameter("title");
        String writer = request.getParameter("writer");
        String content = request.getParameter("content");

        // 2. DB 연동 처리
        BoardVO vo = new BoardVO();
        vo.setTitle(title);
        vo.setWriter(writer);
        vo.setContent(content);

        BoardDAO boardDAO = new BoardDAO();
        boardDAO.insertBoard(vo);

        // 3. 화면 네비게이션
        RequestDispatcher dispatcher = request.getRequestDispatcher("/getBoardList.do");
        dispatcher.forward(request, response);
//        response.sendRedirect("getBoardList.do");
    }
}
