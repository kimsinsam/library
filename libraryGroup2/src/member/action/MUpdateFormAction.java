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
			System.out.println("★수정화면★  execute MUpdateFormAction.java");
			String send_id = request.getParameter("send_id");
			System.out.println(send_id + "★수정화면★ 아이디 받아지냐?");
			//1단계 : Mdao클래스 통해서 새로운 객체를 선언 생성 할당 한다
			Mdao dao = new Mdao();
			//2단계 : Mdao클래스내 1명회원 조회 메서드 선언 후 호출
			Member m = dao.mSelectforUpdate(send_id);
			//3단계 : request영역에 셋팅
			request.setAttribute("m", m);
			//4단계 : 포워드 하기위한 셋팅 후 주소값 컨트롤러로 리턴
			MActionForward forward = new MActionForward();
			forward.setRedirect(false);
			forward.setPath("/Member/m_update_from.jsp");
			return forward;
		}
	}

