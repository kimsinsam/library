package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.Inter.MActionInterFace;
import member.dao.Mdao;
import member.dto.Member;
import member.forward.MActionForward;

public class MUpdateFormAction implements MActionInterFace {

	@Override
		public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			System.out.println("�ڼ���ȭ���  execute MUpdateFormAction.java");
			String send_id = request.getParameter("send_id");
			System.out.println(send_id + "�ڼ���ȭ��� ���̵� �޾�����?");
			//1�ܰ� : MdaoŬ���� ���ؼ� ���ο� ��ü�� ���� ���� �Ҵ� �Ѵ�
			Mdao dao = new Mdao();
			//2�ܰ� : MdaoŬ������ 1��ȸ�� ��ȸ �޼��� ���� �� ȣ��
			Member m = dao.mSelectforUpdate(send_id);
			//3�ܰ� : request������ ����
			request.setAttribute("m", m);
			//4�ܰ� : ������ �ϱ����� ���� �� �ּҰ� ��Ʈ�ѷ��� ����
			MActionForward forward = new MActionForward();
			forward.setRedirect(false);
			forward.setPath("/Member/m_update_from.jsp");
			return forward;
		}
	}

