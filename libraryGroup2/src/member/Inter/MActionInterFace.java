package member.Inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.forward.MActionForward;


public interface MActionInterFace {
	public MActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception;
}





