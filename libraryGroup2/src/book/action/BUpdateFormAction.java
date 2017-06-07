package book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.dao.Bdao;
import book.dto.Book;
import book.forward.BActionForward;
import book.inter.BActionInterFace;

public class BUpdateFormAction implements BActionInterFace {

	@Override
	public BActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String isbn = request.getParameter("bisbn");
		System.out.println("ISBN 코드 확인 : " + isbn);
		
		Bdao dao = new Bdao();
		Book b = dao.bSelectforUpdate(isbn);
		
		request.setAttribute("b", b);
		
		BActionForward forward = new BActionForward();
		forward.setRedirect(false);
		forward.setPath("/Book/b_update_form.jsp");
		return forward;
	}

}
