package book.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import book.dao.Bdao;
import book.dto.Book;
import book.forward.BActionForward;
import book.inter.BActionInterFace;
import member.forward.MActionForward;

public class BRentalCheckListProAcion implements BActionInterFace {

	@Override
	public BActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Bdao dao = new Bdao();
		String mid = (String)session.getAttribute("S_ID");
		
		ArrayList<Book> book = dao.bIdselect(mid);
		
		request.setAttribute("book", book);
		
		BActionForward forward = new BActionForward();
		forward.setRedirect(false);
		forward.setPath("/Book/b_rental_list.jsp");
		return forward;
	}

}
