package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.Inter.MActionInterFace;
import member.dao.Mdao;
import member.forward.MActionForward;

public class MDeleteProAction implements MActionInterFace {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("03 ��üó�� <--execute MDeleteProAction.java");
		//1.ȭ�鿡�� id ���� �޴´�.
		String send_id = request.getParameter("send_id");
		//2. MdaoŬ���� ���ؼ� ���ο� ��ü�� ���� ���� �Ҵ� �Ѵ�.
		Mdao dao = new Mdao();
		//3. Mdao Ŭ���� �� 1�� ȸ�� ��ȸ �޼��� ȣ��
		dao.mDelete(send_id);
		//5. �����̷�Ʈ �ϱ����� ���� �� �ּҰ� ��Ʈ�ѷ��� ����
		MActionForward forward = new MActionForward();
		forward.setRedirect(true);
		forward.setPath(request.getContextPath() + "/Member/m_search_list.mkfc");
		return forward;
	}
}