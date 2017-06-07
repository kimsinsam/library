package rental.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rental.action.*;
import rental.forward.RActionForward;
import rental.inter.RActionInterFace;

@WebServlet("/Rcontroller")
public class Rcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;  
    public Rcontroller() {
        super();      
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("01 doGet 메서드 rental.controller.Rcontroller");
		rprocess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("02 dopost 메서드 rental.controller.Rcontroller");
		rprocess(request, response);
	}
	
	
	private void rprocess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		System.out.println("03 rprocess 메서드 <-- rental.controller.Rcontroller.java");
		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		System.out.println(RequestURI + "<-- RequestURI //rental.controller.Rcontroller.java");
		System.out.println(contextPath + "<-- contextPath //rental.controller.Rcontroller.java");
		System.out.println(contextPath.length() + "<-- contextPath.length() //rental.controller.Rcontroller.java");
		System.out.println(command + "<-- command //rental.controller.Rcontroller.java");
		System.out.println("----------Rcontroller.java----------------");
		RActionInterFace action = null;
		RActionForward forward = null;
		

		if(command.equals("/Rental/r_search_list.rkfc")){
			System.out.println("/Rental/r_search_list.rkfc <--Rcontroller.java");
			action = new RSearchListProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Book/Rental/r_insert_pro.rkfc")){
			System.out.println("/Book/Rental/r_insert_pro.rkfc <--Rcontroller.java");
			action = new RInsertProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Rental/r_delete_pro.rkfc")){
			System.out.println("/Rental/r_delete_pro.rkfc <--Rcontroller.java");
			action = new RDeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Member/r_delete_pro.rkfc")){
			System.out.println("/Member/r_delete_pro.rkfc <--Rcontroller.java");
			action = new RDeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		if(forward != null){
			if(forward.isRedirect()){
				System.out.println(forward.getPath());
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
