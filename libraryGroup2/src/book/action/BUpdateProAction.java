package book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.dao.Bdao;
import book.dto.Book;
import book.forward.BActionForward;
import book.inter.BActionInterFace;

public class BUpdateProAction implements BActionInterFace {

	@Override
	public BActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("euc-kr");
		String bisbn = request.getParameter("bisbn");
		String btitle = request.getParameter("bname");
		String bgenre = request.getParameter("bgenre");
		String bwriter = request.getParameter("bwriter");
		String bpublisher = request.getParameter("bpublisher");
		String bdate = request.getParameter("bdate");
		String bdetail = request.getParameter("bdetail");
		
		System.out.println("BinsertProAction bisbn : "+bisbn);
		System.out.println("BinsertProAction btitle : "+btitle);
		System.out.println("BinsertProAction bgenre : "+bgenre);
		System.out.println("BinsertProAction bwriter : "+bwriter);
		System.out.println("BinsertProAction bpublisher : "+bpublisher);
		System.out.println("BinsertProAction bdate : "+bdate);
		System.out.println("BinsertProAction bdetail : "+bdetail);
		
		Book book = new Book();
		
		book.setISBN(bisbn);
		book.setBtitle(btitle);
		book.setBgenre(bgenre);
		book.setBwriter(bwriter);
		book.setBpublisher(bpublisher);
		book.setBdate(bdate);
		book.setBdetail(bdetail);
		
		Bdao dao = new Bdao();
		
		dao.bUpdate(book);
		
		BActionForward forward = new BActionForward();
		forward.setRedirect(true);
		forward.setPath(request.getContextPath()+"/Book/b_list.bkfc");
		return forward;
	}

}
