package books;

import java.util.ArrayList;


public class BookBean {
	
	private int bid;
	
	private String name;
	
	private int aid;
	
	private int cid;
	
	private ArrayList<BookBean> list=null;
	
	private ArrayList categorylist=null;
	
	private ArrayList authorlist=null;
	
	public BookBean()
	{
		
	}

	public BookBean(int bid, String name, int cid, int aid) {
		super();
		this.bid = bid;
		this.name = name;
		this.cid = cid;
		this.aid = aid;
	}
	public BookBean(int bid, String name,int cid) {
		super();
		this.bid = bid;
		this.name = name;
		this.cid=cid;
	}
	public void setBooksList(ArrayList<BookBean> list)
	{
		this.list=list;
		
		if(list!=null)
		{
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
	}
	
	
	public ArrayList< BookBean> getBooksList()
	{
		return list;
	}
	
	public int getBid()
	{
		return bid;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getCid()
	{
		return cid;
	}
	public int getAid(){
		return aid;
	}
	
	public void setCid(int cid)
	{
		this.cid=cid;
	}
	public void setAid(int aid)
	{
		this.aid=aid;
	}
	public String getCategoryHtmlList()
	{
		StringBuffer buffer=new StringBuffer();
		if(categorylist!=null)
		{
			for (int i = 0; i < categorylist.size(); i++) {
				buffer.append("<option value=");
				buffer.append(i);
				buffer.append(">");
				BookBean b=(BookBean)categorylist.get(i);
				int category=b.getCid();;
				buffer.append(category);
				buffer.append("</option>");
			}
		}
		
		return buffer.toString();
	}
	
	public void setCategoryList(ArrayList list)
	{
		this.categorylist=list;
	}
	
	public ArrayList getCategoryList()
	{
		return categorylist;
	}
	public void setAuthorList(ArrayList list)
	{
		this.authorlist=list;
	}
	public ArrayList getAuthorList()
	{
		return authorlist;
	}
	public String getAuthorHtmlList()
	{
		StringBuffer buffer=new StringBuffer();
		if(authorlist!=null)
		{
			for (int i = 0; i < authorlist.size(); i++) {
				buffer.append("<option value=");
				buffer.append(i);
				buffer.append(">");
				BookBean b=(BookBean)authorlist.get(i);
				int category=b.getAid();;
				buffer.append(category);
				buffer.append("</option>");
			}
		}
		
		return buffer.toString();
	}
}
