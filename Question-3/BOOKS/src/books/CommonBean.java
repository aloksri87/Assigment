package books;

import java.util.ArrayList;
import java.util.Date;

public class CommonBean {
	
	private int bid;
	
	private String title;
	
	private int cid;
	
	private int aid;
	
	private String booktype;
	
	private String fname;
	
	private String lname;
	
	private Date date;

	private ArrayList list;
	public CommonBean(int bid, String title, int cid, int aid, String booktype,
			String fname, String lname, Date date) {
		super();
		this.bid = bid;
		this.title = title;
		this.cid = cid;
		this.aid = aid;
		this.booktype = booktype;
		this.fname = fname;
		this.lname = lname;
		this.date = date;
	}
	public CommonBean(int bid, String title,String booktype) {
		super();
		this.bid = bid;
		this.title = title;
		this.booktype = booktype;
	}
	public CommonBean(int bid2, String title2, String name, String lname2,
			Date date2) {
		this.bid = bid2;
		this.title = title2;
		this.fname = name;
		this.lname = lname2;
		this.date = date2;
	}
	public void setList(ArrayList list)
	{
		this.list=list;
	}
	
	
	public ArrayList getList()
	{
		return list;
	}

	public int getBid() {
		return bid;
	}

	public String getTitle() {
		return title;
	}

	public int getCid() {
		return cid;
	}

	public int getAid() {
		return aid;
	}

	public String getBooktype() {
		return booktype;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public Date getDate() {
		return date;
	}
	

}
