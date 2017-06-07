package book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.dao.Bdao;
import book.forward.BActionForward;
import book.inter.BActionInterFace;

public class BDeleteProAction implements BActionInterFace {

	@Override
	public BActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String isbn = request.getParameter("bisbn");
		
		Bdao dao = new Bdao();
		dao.bDelete(isbn);
		
		BActionForward forward = new BActionForward();
		forward.setRedirect(true);
		forward.setPath(request.getContextPath()+"/Book/b_list.bkfc");
		return forward;
	}

}
