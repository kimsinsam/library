package book.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import book.forward.BActionForward;

public interface BActionInterFace {
	public BActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
