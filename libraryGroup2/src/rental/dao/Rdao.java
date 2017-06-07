package rental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import rental.dto.Rental;

public class Rdao {
	DataSource ds;
	PreparedStatement pstmt;
	Connection conn;
	ResultSet rs;
	public Rdao(){
		Context initCtx;
		try {
			initCtx = new InitialContext();
			Context envCtx=(Context)initCtx.lookup("java:comp/env");
			ds=(DataSource)envCtx.lookup("jdbc/MysqlDB");
			System.out.println("DB ���� ���� �ߺ�");
		} catch (NamingException e) {
			System.out.println("DB ���� ���� : " + e);
			e.printStackTrace();
		}
	}
	//�뿩 ����Ʈ
	public ArrayList<Rental> rAllselect() throws SQLException{
		System.out.println("�뿩 ����Ʈ ��� �޼��� ����- �߻�");
		conn = ds.getConnection();
		String sql="select r.r_code,r.mid,m.mname,r.bisbn,b.btitle,r.rdate,r.rreturn from rental r inner join member m on r.mid = m.mid inner join book b on r.bisbn = b.bisbn";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		ArrayList<Rental> list = new ArrayList<Rental>();
		while(rs.next()){
			Rental r = new Rental();
			r.setRcode(rs.getString("r_code"));
			r.setRid(rs.getString("mid"));
			r.setRname(rs.getString("mname"));
			r.setRisbn(rs.getString("bisbn"));
			r.setRtitle(rs.getString("btitle"));
			r.setRdate(rs.getString("rdate"));
			r.setRreturn(rs.getString("rreturn"));
			list.add(r);
		}
		
		System.out.println("�뿩 ����Ʈ ��� �޼��� ����- �߻�");
		rs.close();
		conn.close();
		pstmt.close();
		return list;
	}
	//�뿩 ����Ʈ �μ�Ʈ
	public void rInsert(String isbn, String mid) throws SQLException{
		System.out.println("�ڴ뿩 ����Ʈ �μ�Ʈ <-- mInsert Mdao.java");
		conn=ds.getConnection();
		conn.setAutoCommit(false);
		try{
		PreparedStatement pstmt2;
		pstmt2 = conn.prepareStatement(
				"UPDATE book SET brental='Y' WHERE bisbn = ?");
		pstmt2.setString(1, isbn);
		pstmt2.executeUpdate();
		pstmt = conn.prepareStatement(
				"INSERT INTO rental(`mid`, `bisbn`, `rdate`, `rreturn`) VALUES (?, ?, now(), now()+ INTERVAL 15 DAY)");
		pstmt.setString(1, mid);
		pstmt.setString(2, isbn);
		pstmt.executeUpdate();
		conn.commit();
		} catch(Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				}
		}

	}
	//�뿩 �ݳ� �޼���
	public void rDlete(String rcode, String isbn) throws ClassNotFoundException, SQLException{
		System.out.println("���� �ݳ� �޼��� ����- �ѻ߻�");
		conn = ds.getConnection();
		pstmt = conn.prepareStatement("DELETE FROM rental WHERE r_code= ?");
		pstmt.setString(1, rcode);
		pstmt.executeUpdate();
		PreparedStatement pstmt2;
		pstmt2 = conn.prepareStatement(
				"UPDATE book SET brental='N' WHERE bisbn = ?");
		pstmt2.setString(1, isbn);
		pstmt2.executeUpdate();
		System.out.println("���� �ݳ� �޼��� ����- �ѻ߻�");
		pstmt.close();
		conn.close();
	}

}
