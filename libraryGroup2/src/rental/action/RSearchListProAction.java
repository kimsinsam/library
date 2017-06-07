package rental.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rental.dao.Rdao;
import rental.dto.Rental;
import rental.forward.RActionForward;
import rental.inter.RActionInterFace;

public class RSearchListProAction implements RActionInterFace {

	@Override
	public RActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("서치리 리스트 구동 rental.action.RSearchListProAction.java");
		
		Rdao dao = new Rdao();
		ArrayList<Rental> list = dao.rAllselect();
		
		request.setAttribute("rlist", list);
		
		RActionForward forward = new RActionForward();
		forward.setRedirect(false);
		forward.setPath("/Rental/r_list.jsp");
		return forward;
	}

}
