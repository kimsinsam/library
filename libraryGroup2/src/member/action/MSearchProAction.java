package member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.Inter.MActionInterFace;
import member.dao.Mdao;
import member.dto.Member;
import member.forward.MActionForward;

public class MSearchProAction implements MActionInterFace {

	@Override
		public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			System.out.println(" ȸ�������˻� �� ����Ʈ <--execute MActionForward.java");
			String sk = request.getParameter("sk");
			String sv = request.getParameter("sv");
			
			Mdao dao = new Mdao();
			
			ArrayList<Member> get_alm = dao.mSearch(sk, sv);
			System.out.println(get_alm + "<--MSearchProAction mdao���� ���ϰ� �� �޾ҳ�?----------");
		
			request.setAttribute("get_alm", get_alm);
			
			MActionForward forward = new MActionForward();
			forward.setRedirect(false);
			forward.setPath("/Member/m_search_list.jsp");
			System.out.println(forward + "<--��MActionForward end----------");
		
			return forward;
			
		}

}
