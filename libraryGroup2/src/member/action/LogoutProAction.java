package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.Inter.MActionInterFace;
import member.forward.MActionForward;

public class LogoutProAction implements MActionInterFace {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();
		
		MActionForward forward = new MActionForward();
		forward.setRedirect(true);
		forward.setPath(request.getContextPath()+"/main.jsp");
		return forward;
	}

}
