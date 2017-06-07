package rental.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rental.dao.Rdao;
import rental.forward.RActionForward;
import rental.inter.RActionInterFace;

public class RInsertProAction implements RActionInterFace {

	@Override
	public RActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String isbn = request.getParameter("bisbn");
		System.out.println("ISBN 코드 확인 : " + isbn);
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("S_ID");
		System.out.println(mid + "<-- mid RinsertProAction.java");
		Rdao dao = new Rdao();
		dao.rInsert(isbn, mid);
		RActionForward forward = new RActionForward();
		forward.setRedirect(true);
		forward.setPath(request.getContextPath()+"/Rental/r_search_list.rkfc");	
		return forward;
	}
}
