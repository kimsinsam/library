package book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import book.dto.Book;

public class Bdao {
	DataSource ds;
	PreparedStatement pstmt;
	Connection conn;
	ResultSet rs;
	public Bdao(){
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
	// ���� �Է� �޼���
	public void bInsert(Book book) throws SQLException{
		System.out.println("���� �Է� �޼��� ����- �ߺ�!");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(
					"INSERT INTO book(bisbn, btitle, bwriter, bgenre, bpublisher, bdate, bdetail) values (?,?,?,?,?,?,?)");
			pstmt.setString(1, book.getISBN());
			pstmt.setString(2, book.getBtitle());
			pstmt.setString(3, book.getBwriter());
			pstmt.setString(4, book.getBgenre());
			pstmt.setString(5, book.getBpublisher());
			pstmt.setString(6, book.getBdate());
			pstmt.setString(7, book.getBdetail());
			
			pstmt.executeUpdate();
			System.out.println("���� �Է� �޼��� ����- �ߺ�!");
			pstmt.close();
			conn.close();
		
	}
	//���� ��ü ����Ʈ ��� �޼���
	public ArrayList<Book> bAllselect() throws SQLException{
		System.out.println("���� ����Ʈ ��� �޼��� ����- �߻�");
		conn = ds.getConnection();
		String sql="select bisbn, btitle, bwriter, bgenre, bpublisher, bdate, bdetail, brental from book";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		ArrayList<Book> list = new ArrayList<Book>();
		while(rs.next()){
			Book b = new Book();
			b.setISBN(rs.getString("bisbn"));
			b.setBtitle(rs.getString("btitle"));
			b.setBwriter(rs.getString("bwriter"));
			b.setBgenre(rs.getString("bgenre"));
			b.setBpublisher(rs.getString("bpublisher"));
			b.setBdate(rs.getString("bdate"));
			b.setBdetail(rs.getString("bdetail"));
			b.setBrental(rs.getString("brental"));
			list.add(b);
		}
		
		System.out.println("���� ����Ʈ ��� �޼��� ����- �߻�");
		rs.close();
		conn.close();
		pstmt.close();
		return list;
	}
	// ���� ��ü�뿩 ����Ʈ
	public ArrayList<Book> bIdselect(String mid) throws SQLException{
		System.out.println("���� ���� ����Ʈ ��� �޼��� ����- �߻�");
		conn = ds.getConnection();
		String sql="select r.r_code, r.bisbn, b.btitle, b.bwriter, b.bgenre, b.bpublisher, b.bdate, b.bdetail, b.brental from rental r inner join book b on r.bisbn = b.bisbn where r.mid = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mid);
		rs = pstmt.executeQuery();
		ArrayList<Book> list = new ArrayList<Book>();
		while(rs.next()){
			Book b = new Book();
			b.setRcode(rs.getString("r_code"));
			b.setISBN(rs.getString("bisbn"));
			b.setBtitle(rs.getString("btitle"));
			b.setBwriter(rs.getString("bwriter"));
			b.setBgenre(rs.getString("bgenre"));
			b.setBpublisher(rs.getString("bpublisher"));
			b.setBdate(rs.getString("bdate"));
			b.setBdetail(rs.getString("bdetail"));
			list.add(b);
		}
		
		System.out.println("���� ���� ����Ʈ ��� �޼��� ����- �߻�");
		rs.close();
		conn.close();
		pstmt.close();
		return list;
	}
	//���� ���� ���� ����Ʈ
	public Book bSelectforUpdate(String isbn) throws SQLException{
		System.out.println("���� ���� ���� ����Ʈ ����- �ߺ�!");
		conn = ds.getConnection();
		pstmt = conn.prepareStatement("select * from book WHERE bisbn=?");
		pstmt.setString(1, isbn);
		
		rs = pstmt.executeQuery();
		Book b = null;
		if(rs.next()){
			b = new Book();
			b.setISBN(rs.getString("bisbn"));
			b.setBtitle(rs.getString("btitle"));
			b.setBwriter(rs.getString("bwriter"));
			b.setBgenre(rs.getString("bgenre"));
			b.setBpublisher(rs.getString("bpublisher"));
			b.setBdate(rs.getString("bdate"));
			b.setBdetail(rs.getString("bdetail"));
		}
		System.out.println("���� ���� ���� ����Ʈ ����- �ߺ�!");
		rs.close();
		pstmt.close();
		conn.close();
		
		return b;
	}
	//�������� �Է� ����Ʈ
	public void bUpdate(Book book) throws SQLException{
		System.out.println("���� ���� �޼��� ����- �ػ�!");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(
					"UPDATE book SET btitle=?,bwriter=?,bgenre=?,bpublisher=?,bdate=?,bdetail=? WHERE bisbn = ?");
			
			pstmt.setString(1, book.getBtitle());
			pstmt.setString(2, book.getBwriter());
			pstmt.setString(3, book.getBgenre());
			pstmt.setString(4, book.getBpublisher());
			pstmt.setString(5, book.getBdate());
			pstmt.setString(6, book.getBdetail());
			pstmt.setString(7, book.getISBN());
			
			pstmt.executeUpdate();
			System.out.println("���� ���� �޼��� ����- �ػ�!");
			pstmt.close();
			conn.close();
		
	}
	//���� ���� �޼���
	public void bDelete(String isbn) throws ClassNotFoundException, SQLException{
		System.out.println("���� ���� �޼��� ����- �ѻ߻�");
		conn = ds.getConnection();
		pstmt = conn.prepareStatement("DELETE FROM book WHERE bisbn= ?");
		pstmt.setString(1, isbn);
		pstmt.executeUpdate();
		System.out.println("���� ���� �޼��� ����- �ѻ߻�");
		pstmt.close();
		conn.close();
	}
}
