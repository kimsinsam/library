package book.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.action.BDeleteProAction;
import book.action.BListProAction;
import book.action.BRentalCheckListProAcion;
import book.action.BUpdateFormAction;
import book.action.BUpdateProAction;
import book.action.BinsertProAction;
import book.forward.BActionForward;
import book.inter.BActionInterFace;

@WebServlet("/Bcontroller")
public class Bcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;  
    public Bcontroller() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("01 doGet 메서드 book.controller.Bcontroller");
		bprocess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("02 dopost 메서드 book.controller.Bcontroller");
		bprocess(request, response);
	}
	
	
	private void bprocess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		System.out.println("02 bprocess 메서드 book.controller.Bcontroller");
		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		System.out.println(RequestURI + "<-- RequestURI BController.java");
		System.out.println(contextPath + "<-- contextPath BController.java");
		System.out.println(contextPath.length() + "<-- contextPath.length() BController.java");
		System.out.println(command + "<-- command BController.java");
		System.out.println("----------BController.java----------------");
		BActionInterFace action = null;
		BActionForward forward = null;
		
		if(command.equals("/Book/b_insert_form.bkfc")){
			System.out.println("/Book/b_insert_form.bkfc Bcontroller.java");
			forward = new BActionForward();
			forward.setRedirect(false);
			forward.setPath("/Book/b_insert_form.jsp");
		}else if(command.equals("/Book/b_insert_pro.bkfc")){
			System.out.println("/Book/b_insert_pro.bkfc Bcontroller.java");
			action = new BinsertProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Book/b_list.bkfc")){
			System.out.println("/Book/b_list.bkfc Bcontroller.java");
			action = new BListProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Book/b_update_form.bkfc")){
			System.out.println("/Book/b_update_form.bkfc Bcontroller.java");
			action = new BUpdateFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Book/b_update_pro.bkfc")){
			System.out.println("/Book/b_update_pro.bkfc Bcontroller.java");
			action = new BUpdateProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Book/b_delete_pro.bkfc")){
			System.out.println("/Book/b_delete_pro.bkfc Bcontroller.java");
			action = new BDeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Member/check_rental.bkfc")){
			System.out.println("/Member/check_rental.bkfc Bcontroller.java");
			action = new BRentalCheckListProAcion();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		if(forward != null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher=
					request.getRequestDispatcher(forward.getPath());
				System.out.println(forward.getPath() + "<--- forward.getPath()[jsp 이동경로]  MController.java");
				System.out.println();
				dispatcher.forward(request, response);
			}
		}
	}
}
