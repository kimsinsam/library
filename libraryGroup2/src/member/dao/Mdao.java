package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import member.dto.Member;



public class Mdao {

	DataSource ds;
	PreparedStatement pstmt;
	Connection conn;
	ResultSet rs;
	public Mdao(){
		Context initCtx;
		try {
			initCtx = new InitialContext();
			Context envCtx=(Context)initCtx.lookup("java:comp/env");
			ds=(DataSource)envCtx.lookup("jdbc/MysqlDB");
		} catch (NamingException e) {
			System.out.println("DB ���� ���� : " + e);
			e.printStackTrace();
		}

	}
	// �Ϲ�ȸ�� ���� mypage ȸ����������
	
	public void nMupdate(Member m) throws ClassNotFoundException, SQLException{
		System.out.println("�� ����ó�� <-- mUpdate Mdao.java");
		conn=ds.getConnection();
		pstmt = conn.prepareStatement(
				"UPDATE member SET mpw=?, mname=?, mbirth=?, maddr=?, mtel=?, memail=? WHERE mid = ?");
		pstmt.setString(1, m.getMpw());
		pstmt.setString(2, m.getMname());	
		pstmt.setString(3, m.getMbirth());
		pstmt.setString(4, m.getMaddr());
		pstmt.setString(5, m.getMtel());
		pstmt.setString(6, m.getMemail());
		pstmt.setString(8, m.getMid());
		
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	
	
	// �α��� ���� ����
	public Member mGetForSession(String in_id) throws SQLException{
		System.out.println("�ڼ��ǿ� �̸��� ���� ���� <-- mGetForSession Mdao.java");
		conn=ds.getConnection();
		pstmt = conn.prepareStatement("select mname, mlevel, mid from member WHERE mid=?");
		pstmt.setString(1, in_id);
		
		rs = pstmt.executeQuery();
		Member m = new Member();
		if(rs.next()){
			//������������ MemberŬ���� ���ؼ� ������ ��ü���� ����
			m.setMname(rs.getString("mname"));
			m.setMlevel(rs.getString("mlevel"));
			m.setMid(rs.getString("mid"));
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return m;
	}
	// �α���
	public char mLoginCheck(String in_id,String in_pw) throws SQLException{
		System.out.println("�� �α��� <- mLoginCheck Mdao.java");
		System.out.println(in_id + "<-- in_id mLoginCheck Mdao.java");
		System.out.println(in_pw + "<-- in_pw mLoginCheck Mdao.java");
		char re;
		conn=ds.getConnection();
		pstmt = conn.prepareStatement("select mpw from member WHERE mid=?");
		pstmt.setString(1, in_id);
		
		rs = pstmt.executeQuery();	
		if(rs.next()){
			if(in_pw.equals(rs.getString("mpw"))){
				System.out.println("�α��μ���");
				//re = 1;
				re = 'A';
			}else{
				System.out.println("��й�ȣ����ġ");
				//re = 3;
				re = 'C';
			}
		}else{
			System.out.println("���� ���̵�");
			//re = 2;
			re = 'B';
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return re;
	}
	
	// ����ó��
	public void mUpdate(Member m) throws ClassNotFoundException, SQLException{
		System.out.println("�� ����ó�� <-- mUpdate Mdao.java");
		conn=ds.getConnection();
		pstmt = conn.prepareStatement(
				"UPDATE member SET mpw=?, mname=?, mbirth=?, maddr=?, mtel=?, memail=?, mlevel=? WHERE mid = ?");
		pstmt.setString(1, m.getMpw());
		pstmt.setString(2, m.getMname());	
		pstmt.setString(3, m.getMbirth());
		pstmt.setString(4, m.getMaddr());
		pstmt.setString(5, m.getMtel());
		pstmt.setString(6, m.getMemail());
		pstmt.setString(7, m.getMlevel());
		pstmt.setString(8, m.getMid());
		
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	
	// ȸ�������������� ����Ʈ
	public Member mSelectforUpdate(String mid) throws ClassNotFoundException, SQLException{
		System.out.println("�� ȸ������ ������ ���� select <-- mSelectforUpdate Mdao.java");
		conn=ds.getConnection();
		pstmt = conn.prepareStatement("select mid, mpw, mname, mbirth, maddr, mtel, memail from member where mid=?");
		pstmt.setString(1, mid);
		rs = pstmt.executeQuery();
		Member m = new Member();
		if(rs.next()){
			
			m.setMid(rs.getString("mid"));
			m.setMpw(rs.getString("mpw"));
			m.setMname(rs.getString("mname"));
			m.setMbirth(rs.getString("mbirth"));
			m.setMaddr(rs.getString("maddr"));
			m.setMtel(rs.getString("mtel"));
			m.setMemail(rs.getString("memail"));
		}		
		pstmt.close();
		conn.close();		
		return m;
	}
	
	// ȸ����������
	public void mDelete(String mid) throws ClassNotFoundException, SQLException{
		System.out.println("�� ����ó�� <-- mDelete Mdao.java");
		conn=ds.getConnection();
		pstmt = conn.prepareStatement("DELETE FROM member WHERE mid= ?");
		pstmt.setString(1, mid);
		pstmt.executeUpdate();

		pstmt.close();
		conn.close();
	}
	
	// �˻�ó��
	public ArrayList<Member> mSearch(String sk,String sv) throws SQLException{
		System.out.println("�� �˻� <-- mSearch Mdao.java");
		System.out.println(sk + "<-- sk mSearch Mdao.java");
		System.out.println(sv + "<-- sv mSearch Mdao.java");
		conn=ds.getConnection();
		
		if(sk == null & sv == null){
			System.out.println("01 �Ѵ� ���� ����");
			pstmt = conn.prepareStatement("select * from member");
		}else if(sk != null & sv.equals("")){
			System.out.println("02 sk�ְ� sv����");
			pstmt = conn.prepareStatement("select * from member");
		}else if(sk != null & sv != null){
			System.out.println("03 �Ѵ� �ִ�");
			pstmt = conn.prepareStatement("select * from member where " + sk +" =?");	
			pstmt.setString(1, sv);	
		}		
		rs = pstmt.executeQuery();
		
		ArrayList<Member> alm = new ArrayList<Member>();
		
		while(rs.next()){
			Member m = new Member();
			m.setMid(rs.getString("mid"));
			m.setMname(rs.getString("mname"));
			m.setMbirth(rs.getString("mbirth"));
			m.setMaddr(rs.getString("maddr"));
			m.setMtel(rs.getString("mtel"));
			m.setMemail(rs.getString("memail"));
			m.setMlevel(rs.getString("mlevel"));
			m.setMrental(rs.getString("mrental"));
			m.setMrentalno(rs.getString("mrentalno"));
			alm.add(m);
			System.out.println(alm + "<-- alm");
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return alm;
	}
		
		//ȸ������ó��
		public void mInsert(Member m) throws SQLException, ClassNotFoundException{
			System.out.println("�� ȸ������ <-- mInsert Mdao.java");
			conn=ds.getConnection();
			pstmt = conn.prepareStatement(
					"INSERT INTO member(mid, mpw, mname, mbirth, maddr, mtel, memail) VALUES (?, ?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, m.getMid());
			pstmt.setString(2, m.getMpw());
			pstmt.setString(3, m.getMname());
			pstmt.setString(4, m.getMbirth());
			pstmt.setString(5, m.getMaddr());
			pstmt.setString(6, m.getMtel());
			pstmt.setString(7, m.getMemail());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		}
						
}

