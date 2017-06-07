package member.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.Inter.MActionInterFace;
import member.action.LoginProAction;
import member.action.LogoutProAction;
import member.action.MDeleteProAction;
import member.action.MInsertProAction;
import member.action.MSearchProAction;
import member.action.MUpdateFormAction;
import member.action.MUpdateProAction;
import member.action.MyPageDropFormAction;
import member.action.MyPageFormAction;
import member.action.MyPageUpdateProAction;
import member.forward.MActionForward;

@WebServlet("/MController")
public class MController extends HttpServlet {
	private static final long serialVersionUID = 1L;   
    public MController() {
        super();
       
    }
    private void mProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("euc-kr");
    	System.out.println("03_mProcess MController");
		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		System.out.println(RequestURI + "<-- RequestURI MController.java");
		System.out.println(contextPath + "<-- contextPath MController.java");
		System.out.println(contextPath.length() + "<-- contextPath.length() MController.java");
		System.out.println(command + "<-- command MController.java");
		System.out.println("----------MController.java----------------");
		MActionForward forward = null;
		MActionInterFace action = null;
		if(command.equals("/main.mkfc")){
			System.out.println("/main.mkfc MController.java");	
			forward = new MActionForward();
			forward.setRedirect(true);
			forward.setPath(request.getContextPath()+"/main.jsp");
		}else if(command.equals("/Member/m_insert_form.mkfc")){
			System.out.println("/Member/m_insert_form.mkfc <-- MController.java");	
			forward = new MActionForward();
			forward.setRedirect(true);
			forward.setPath(request.getContextPath() + "/Member/m_insert_form.jsp");
		}else if(command.equals("/Member/m_insert_pro.mkfc")){
			System.out.println("/Member/m_insert_pro.mkfc <-- MController.java");
			action = new MInsertProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}else if(command.equals("/Member/m_search_list.mkfc")){
			System.out.println("/Member/m_search_list.mkfc <-- MController.java");
			action = new MSearchProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Member/m_update_form.mkfc")){
			System.out.println("/Member/m_update_form.mkfc <-- MController.java");	
			action = new MUpdateFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Member/m_update_pro.mkfc")){
			System.out.println("/Member/m_update_pro.mkfc <-- MController.java");
			action = new MUpdateProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Member/m_delete_pro.mkfc")){
			System.out.println("/Member/m_delete_pro.mkfc <-- MController.java");
			action = new MDeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Login/login_pro.mkfc")){
			System.out.println("/Login/login_pro.mkfc <-- MController.java");
			action = new LoginProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Login/logout_pro.mkfc")){
			System.out.println("/Login/logout_pro.mkfc <-- MController.java");
			action = new LogoutProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Member/m_mypage_form.mkfc")){
			System.out.println("/Member/m_mypage_form.mkfc <-- MController.java");
			action = new MyPageFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Member/m_mypage_up_pro.mkfc")){
			System.out.println("/Member/m_mypage_up_pro.mkfc <-- MController.java");
			action = new MyPageUpdateProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Member/m_mypage_drop_from.mkfc")){
			System.out.println("/Member/m_mypage_drop_from.mkfc <-- MController.java");
			action = new MyPageDropFormAction();
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
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		mProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		mProcess(request, response);
	}

}
