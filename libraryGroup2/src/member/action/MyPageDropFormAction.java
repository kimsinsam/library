package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.Inter.MActionInterFace;
import member.dao.Mdao;
import member.dto.Member;
import member.forward.MActionForward;

public class MyPageDropFormAction implements MActionInterFace {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("���Ϲ�ȸ�� Ż��ȭ���  execute MUpdateFormAction.java");
		
		HttpSession session = request.getSession();
		String S_ID = (String)session.getAttribute("S_ID");
		System.out.println(S_ID + "<-- S_ID -- MUpdateFormAction.java");
		
		Mdao dao = new Mdao();
	
		Member m = dao.mSelectforUpdate(S_ID);

		request.setAttribute("m", m);
		//4�ܰ� : ������ �ϱ����� ���� �� �ּҰ� ��Ʈ�ѷ��� ����
		MActionForward forward = new MActionForward();
		forward.setRedirect(true);
		forward.setPath(request.getContextPath()+"/Member/m_mypage_drop_from.jsp");
		return forward;
	}

}
