package rental.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rental.dao.Rdao;
import rental.forward.RActionForward;
import rental.inter.RActionInterFace;

public class RDeleteProAction implements RActionInterFace {

	@Override
	public RActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String rcode = request.getParameter("rcode");
		String isbn = request.getParameter("risbn");
		System.out.println("RDeleteProAction.java rocde 확인 : " + rcode);
		System.out.println("RDeleteProAction.java risbn 확인 : " + isbn);
		
		Rdao dao = new Rdao();
		dao.rDlete(rcode, isbn);
				
		RActionForward forward = new RActionForward();
		forward.setRedirect(true);
		forward.setPath(request.getContextPath()+"/Rental/r_search_list.rkfc");
		return forward;
	}

}
