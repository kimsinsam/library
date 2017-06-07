package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.Inter.MActionInterFace;
import member.dao.Mdao;
import member.dto.Member;
import member.forward.MActionForward;

public class MInsertProAction implements MActionInterFace {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("01 회원가입처리 <--execute MInsertProAction.java");
	
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String mbirth = request.getParameter("mbirth");
		String maddr = request.getParameter("maddr");
		String mtel = request.getParameter("mtel");
		String memail = request.getParameter("memail");
		System.out.println(mid + "<-- mid MInsertProAction.java");
		System.out.println(mpw + "<-- mpw MInsertProAction.java");
		System.out.println(mname + "<-- mname MInsertProAction.java");
		System.out.println(mbirth + "<-- mbirth MInsertProAction.java");
		System.out.println(maddr + "<-- maddr MInsertProAction.java");	
		System.out.println(mtel + "<-- mtel MInsertProAction.java");
		System.out.println(memail + "<-- memail MInsertProAction.java");
		
		Member m = new Member();
		m.setMid(mid);
		m.setMpw(mpw);
		m.setMname(mname);
		m.setMbirth(mbirth);
		m.setMaddr(maddr);
		m.setMtel(mtel);
		m.setMemail(memail);
		
		Mdao dao = new Mdao();
		dao.mInsert(m);
		
		MActionForward forward = new MActionForward();
		
		forward.setRedirect(true);
		forward.setPath(request.getContextPath() +"/main.jsp");
		return forward;
	}

}
