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
			System.out.println("DB 연결 성공 삐빅");
		} catch (NamingException e) {
			System.out.println("DB 연결 실패 : " + e);
			e.printStackTrace();
		}

	}
	// 도서 입력 메서드
	public void bInsert(Book book) throws SQLException{
		System.out.println("도서 입력 메서드 실행- 삐빅!");
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
			System.out.println("도서 입력 메서드 종료- 삐빅!");
			pstmt.close();
			conn.close();
		
	}
	//도서 전체 리스트 출력 메서드
	public ArrayList<Book> bAllselect() throws SQLException{
		System.out.println("도서 리스트 출력 메서드 실행- 삐쀼");
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
		
		System.out.println("도서 리스트 출력 메서드 종료- 삐쀼");
		rs.close();
		conn.close();
		pstmt.close();
		return list;
	}
	// 개인 전체대여 리스트
	public ArrayList<Book> bIdselect(String mid) throws SQLException{
		System.out.println("개인 도서 리스트 출력 메서드 실행- 삐쀼");
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
		
		System.out.println("개인 도서 리스트 출력 메서드 종료- 삐쀼");
		rs.close();
		conn.close();
		pstmt.close();
		return list;
	}
	//수정 도서 단일 셀렉트
	public Book bSelectforUpdate(String isbn) throws SQLException{
		System.out.println("수정 도서 단일 셀렉트 실행- 삐빔!");
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
		System.out.println("수정 도서 단일 셀렉트 종료- 삐빔!");
		rs.close();
		pstmt.close();
		conn.close();
		
		return b;
	}
	//수정도서 입력 셀렉트
	public void bUpdate(Book book) throws SQLException{
		System.out.println("도서 수정 메서드 실행- 쀼삡!");
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
			System.out.println("도서 수정 메서드 종료- 쀼삡!");
			pstmt.close();
			conn.close();
		
	}
	//도서 삭제 메서드
	public void bDelete(String isbn) throws ClassNotFoundException, SQLException{
		System.out.println("도서 삭제 메서드 실행- 뿌삐뿌");
		conn = ds.getConnection();
		pstmt = conn.prepareStatement("DELETE FROM book WHERE bisbn= ?");
		pstmt.setString(1, isbn);
		pstmt.executeUpdate();
		System.out.println("도서 삭제 메서드 종료- 뿌삐뿌");
		pstmt.close();
		conn.close();
	}
}
