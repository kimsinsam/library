package book.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.dao.Bdao;
import book.dto.Book;
import book.forward.BActionForward;
import book.inter.BActionInterFace;

public class BListProAction implements BActionInterFace {

	@Override
	public BActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Bdao dao = new Bdao();
		
		ArrayList<Book> list = dao.bAllselect();
			
		request.setAttribute("list", list);

		BActionForward forward = new BActionForward();
		forward.setRedirect(false);
		forward.setPath("/Book/b_list.jsp");
		return forward;
	}

}
