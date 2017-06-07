package book.dto;

public class Book {
	private String rcode;
	public String getRcode() {
		return rcode;
	}
	public void setRcode(String rcode) {
		this.rcode = rcode;
	}
	private String ISBN;
	private String bcode;
	private String btitle;
	private String bgenre;
	private String bwriter;
	private String bpublisher;
	private String bdate;
	private String bdetail;
	private String brental;
	private String bindate;
	private String mid;
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		System.out.println("book.dto.Book.java iSBN : " + iSBN);
		ISBN = iSBN;
	}
	public String getBcode() {
		return bcode;
	}
	public void setBcode(String bcode) {
		System.out.println("book.dto.Book.java bcode : " + bcode);
		this.bcode = bcode;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		System.out.println("book.dto.Book.java btitle : " + btitle);
		this.btitle = btitle;
	}
	public String getBgenre() {
		return bgenre;
	}
	public void setBgenre(String bgenre) {
		System.out.println("book.dto.Book.java bgenre : " + bgenre);
		this.bgenre = bgenre;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		System.out.println("book.dto.Book.java bwriter : " + bwriter);
		this.bwriter = bwriter;
	}
	public String getBpublisher() {
		return bpublisher;
	}
	public void setBpublisher(String bpublisher) {
		System.out.println("book.dto.Book.java bpublisher : " + bpublisher);
		this.bpublisher = bpublisher;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		System.out.println("book.dto.Book.java bdate : " + bdate);
		this.bdate = bdate;
	}
	public String getBdetail() {
		return bdetail;
	}
	public void setBdetail(String bdetail) {
		System.out.println("book.dto.Book.java bdetail : " + bdetail);
		this.bdetail = bdetail;
	}
	public String getBrental() {
		return brental;
	}
	public void setBrental(String brental) {
		System.out.println("book.dto.Book.java brental : " + brental);
		this.brental = brental;
	}
	public String getBindate() {
		return bindate;
	}
	public void setBindate(String bindate) {
		System.out.println("book.dto.Book.java bindate : " + bindate);
		this.bindate = bindate;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		System.out.println("book.dto.Book.java mid : " + mid);
		this.mid = mid;
	}
	
}
