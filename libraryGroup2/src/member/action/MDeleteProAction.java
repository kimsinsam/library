package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.Inter.MActionInterFace;
import member.dao.Mdao;
import member.forward.MActionForward;

public class MDeleteProAction implements MActionInterFace {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("03 삭체처리 <--execute MDeleteProAction.java");
		//1.화면에서 id 값을 받는다.
		String send_id = request.getParameter("send_id");
		//2. Mdao클래스 통해서 새로운 객체를 선언 생성 할당 한다.
		Mdao dao = new Mdao();
		//3. Mdao 클래스 내 1명 회원 조회 메서드 호출
		dao.mDelete(send_id);
		//5. 리다이렉트 하기위한 셋팅 후 주소값 컨트롤러로 리턴
		MActionForward forward = new MActionForward();
		forward.setRedirect(true);
		forward.setPath(request.getContextPath() + "/Member/m_search_list.mkfc");
		return forward;
	}
}