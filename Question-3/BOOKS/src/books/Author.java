package books;

import java.util.ArrayList;
import java.util.Date;


public class Author {
	
	private int aid;
	
	private String fname;
	
	private String lname;
	
	private Date date;
	
	private ArrayList list;

	public Author(int aid, String fname, String lname, Date date) {
		super();
		this.aid = aid;
		this.fname = fname;
		this.lname = lname;
		this.date = date;
	}

	public int getAid() {
		return aid;
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
	
	
	public void setList(ArrayList list)
	{
		this.list=list;
	}
	
	public ArrayList getList()
	{
		return list;
	}

}
