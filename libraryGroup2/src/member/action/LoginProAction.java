package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.Inter.MActionInterFace;
import member.dao.Mdao;
import member.dto.Member;
import member.forward.MActionForward;

public class LoginProAction implements MActionInterFace {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" ¡Ú·Î±×ÀÎ~ execute LoginProAction.java");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println(id +"<-id LoginProAction.java");
		System.out.println(pw +"<-pw LoginProAction.java");
		Mdao dao = new Mdao();
		char re = dao.mLoginCheck(id, pw);
		if(re == 'A'){
					
					dao = new Mdao();
					Member m = dao.mGetForSession(id);
					HttpSession session = request.getSession();
					session.setAttribute("S_NAME", m.getMname());
					session.setAttribute("S_LEVEL", m.getMlevel());
					session.setAttribute("S_ID", m.getMid());
					
					MActionForward forward = new MActionForward();
					forward.setRedirect(false);
					forward.setPath("/main.jsp");
					return forward;
				}else{
					MActionForward forward = new MActionForward();
					forward.setRedirect(true);
					forward.setPath(request.getContextPath()+"/main.jsp");
					return forward;
			}
		}
	}
	
