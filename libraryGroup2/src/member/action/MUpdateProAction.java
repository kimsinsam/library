package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.Mdao;
import member.dto.Member;
import member.Inter.MActionInterFace;
import member.forward.MActionForward;

public class MUpdateProAction implements MActionInterFace {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("★수정처리★  execute MListProAction.java");
		request.setCharacterEncoding("euc-kr");
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String mbirth = request.getParameter("mbirth");
		String maddr = request.getParameter("maddr");
		String mtel = request.getParameter("mtel");
		String memail = request.getParameter("memail");
		String mlevel = request.getParameter("mlevel");
		System.out.println(mid + "<-- mid MUpdateProAction.java");
		System.out.println(mpw + "<-- mpw MUpdateProAction.java");
		System.out.println(mname + "<-- mname MUpdateProAction.java");
		System.out.println(mbirth + "<-- mbirth MUpdateProAction.java");
		System.out.println(maddr + "<-- maddr MUpdateProAction.java");	
		System.out.println(mtel + "<-- mtel MUpdateProAction.java");
		System.out.println(memail + "<-- memail MUpdateProAction.java");
		System.out.println(mlevel + "<-- mlevel MUpdateProAction.java");
		
		Member m = new Member();
		
		m.setMpw(mpw);
		m.setMname(mname);
		m.setMbirth(mbirth);
		m.setMaddr(maddr);
		m.setMtel(mtel);
		m.setMemail(memail);
		m.setMlevel(mlevel);
		m.setMid(mid);
		
		Mdao dao = new Mdao();
		dao.mUpdate(m);

		request.setAttribute("m", m);

		MActionForward forward = new MActionForward();
		forward.setRedirect(false);
		forward.setPath("/Member/m_search_list.mkfc");
		return forward;
	}
}
