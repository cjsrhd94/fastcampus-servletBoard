package com.fastcampus.controller.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastcampus.biz.board.BoardDAO;
import com.fastcampus.biz.board.BoardVO;

public class GetBoardListServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. DB ���� ó��
        BoardVO vo = new BoardVO();
        BoardDAO boardDAO = new BoardDAO();
        List<BoardVO> boardList = boardDAO.getBoardList(vo);

        // 2. ���� ȭ�� ����
        // ��� ��Ʈ���� ��� ���� ���� �޽����� ���� ���ڵ��� �����Ѵ�.
        response.setContentType("text/html;charset=EUC-KR");

        // Http ���� �������� Body�� ����� ��� ��Ʈ���� ��´�.
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=EUC-KR'>");
        out.println("<title>�� ���</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<center>");
        out.println("<h1>�Խ� �� ���</h1>");
        out.println("<h3>�׽��ʹ� �α��� ȯ���մϴ�...<a href='logout_proc.jsp'>LOG-OUT</a></h3>");
        out.println("<!-- �˻� ���� -->");
        out.println("<form action='getBoardList.jsp' method='post'>");
        out.println("<table border='1' cellpadding='0' cellspacing='0' width='700'>");
        out.println("<tr>");
        out.println("<td align='right'>");
        out.println("<select name='searchCondition'>");
        out.println("<option value='TITLE'>����</option>");
        out.println("<option value='CONTENT'>����</option>");
        out.println("</select>");
        out.println("<input name='searchKeyword' type='text'/>");
        out.println("<input type='submit' value='�˻�'/>");
        out.println("</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</form>");
        out.println("<!-- �˻� ���� -->");
        out.println("<table border='1' cellpadding='0' cellspacing='0' width='700'>");
        out.println("<tr>");
        out.println("<th bgcolor='orange' width='100'>��ȣ</th>");
        out.println("<th bgcolor='orange' width='200'>����</th>");
        out.println("<th bgcolor='orange' width='150'>�ۼ���</th>");
        out.println("<th bgcolor='orange' width='150'>�����</th>");
        out.println("<th bgcolor='orange' width='100'>��ȸ��</th>");
        out.println("</tr>");

        for(BoardVO board : boardList) {
            out.println("<tr>");
            out.println("<td>" + board.getSeq() + "</td>");
            out.println("<td align='left'><a href='getBoard.do?seq=" + board.getSeq() + "'>" + board.getTitle() + "</a></td>");
            out.println("<td>" + board.getWriter() + "</td>");
            out.println("<td>" + board.getRegDate() + "</td>");
            out.println("<td>" + board.getCnt() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("<br>");
        out.println("<a href='insertBoard.html'>���� ���</a>");
        out.println("</center>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }

}
