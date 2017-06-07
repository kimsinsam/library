package rental.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rental.forward.RActionForward;

public interface RActionInterFace {
	public RActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
