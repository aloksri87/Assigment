

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import books.BookBean;
import books.CommonBean;

/**
 * Servlet implementation class Book
 */
@WebServlet("/books")
public class Book extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Book() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        
        String driver="oracle.jdbc.driver.OracleDriver";  
        
        try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			
			System.out.println("ClassNotFound");
		}
        try {
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","abc123");
			System.out.println("Connection Successfull");
			if (request.getParameter("homesend") != null
					&& request.getParameter("homesend")
							.equalsIgnoreCase("home")) {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("Home.jsp");
				dispatcher.forward(request, response);

			}
			else if(request.getParameter("newbookcreate") != null
					&& request.getParameter("newbookcreate")
					.equalsIgnoreCase("newbookcreate"))
			{
				Statement stmt = con.createStatement();
				String sql1 = "select cid from category";
				ResultSet rs = stmt.executeQuery(sql1);
				ArrayList<BookBean> list = new ArrayList<BookBean>();
				BookBean categorybookbean = null;
				while (rs.next()) {
					int cid = rs.getInt(1);
					categorybookbean = new BookBean();
					categorybookbean.setCid(cid);
					list.add(categorybookbean);

				}
				if(categorybookbean!=null)
				{
				categorybookbean.setCategoryList(list);
				}
				getServletContext().setAttribute("categorybookbean", categorybookbean);
				
				BookBean authorbookbean = null;
				Statement stmt1 = con.createStatement();
				String sql11 = "select aid from Author";
				ResultSet rs1 = stmt1.executeQuery(sql11);
				ArrayList<BookBean> list1 = new ArrayList<BookBean>();
				
				while (rs1.next()) {
					int aid = rs1.getInt(1);
					authorbookbean = new BookBean();
					authorbookbean.setAid(aid);
					list1.add(authorbookbean);

				}
				if(authorbookbean!=null)
				authorbookbean.setAuthorList(list1);
				//request.setAttribute("authorbookbean", authorbookbean);
				getServletContext().setAttribute("authorbookbean", authorbookbean);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("createBook.jsp");
				dispatcher.forward(request, response);
			}
			else if (request.getParameter("homesend") != null
					&& request.getParameter("homesend")
							.equalsIgnoreCase("home")) {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("Home.jsp");
				dispatcher.forward(request, response);

			} else if (request.getParameter("deleteion") != null) {
				PreparedStatement pstmt1 = con
						.prepareStatement("delete from books where bid=?");
				pstmt1.setInt(1,
						Integer.parseInt(request.getParameter("bidsend")));
				pstmt1.executeUpdate();

				Statement stmt = con.createStatement();
				String sql1 = "select * from BOOKS";
				ResultSet rs = stmt.executeQuery(sql1);
				ArrayList<BookBean> list = new ArrayList<BookBean>();
				BookBean bookbean = null;
				while (rs.next()) {
					int bid = rs.getInt(1);
					String title = rs.getString(2);
					int cid = rs.getInt(3);
					int aid = rs.getInt(4);

					bookbean = new BookBean(bid, title, cid, aid);
					list.add(bookbean);

				}
				bookbean.setBooksList(list);
				request.setAttribute("bookbean", bookbean);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("books.jsp");
				dispatcher.forward(request, response);
			}

			else if (request.getParameter("id") != null) {
				System.out.println("insid bookid" + request.getParameter("id"));
				Statement stmt = con.createStatement();
				String sql1 = "select B1.BID,B1.TITLE,B1.CID,B1.AID,C1.NAME,A1.NAME,A1.LASTNAME,A1.BIRTHDAY from BOOKS B1,Author A1,CATEGORY C1 WHERE B1.CID=C1.CID AND B1.AID=A1.AID AND B1.BID="
						+ Integer.parseInt(request.getParameter("id"));
				ResultSet rs = stmt.executeQuery(sql1);

				CommonBean cob = null;
				while (rs.next()) {
					int bid = rs.getInt(1);
					String title = rs.getString(2);
					int cid = rs.getInt(3);
					int aid = rs.getInt(4);
					String categorytype = rs.getString(5);
					String authorfirstname = rs.getString(6);
					String authorlastname = rs.getString(7);
					java.util.Date date = rs.getDate(8);

					cob = new CommonBean(bid, title, cid, aid, categorytype,
							authorfirstname, authorlastname, date);

				}
				request.setAttribute("commonbookbean", cob);
				RequestDispatcher view = request
						.getRequestDispatcher("BookDetail.jsp");
				view.forward(request, response);
			}
			else if (request.getParameter("cid") != null) {
				
				Statement stmt = con.createStatement();
				String sql1 = "select B1.BID,B1.TITLE,C1.NAME from BOOKS B1,CATEGORY C1 WHERE B1.CID=C1.CID AND B1.CID="
						+ Integer.parseInt(request.getParameter("cid"));
				ResultSet rs = stmt.executeQuery(sql1);

				CommonBean cob = null;
				ArrayList list=new ArrayList();
				while (rs.next()) {
					int bid = rs.getInt(1);
					String title = rs.getString(2);
                    String cname= rs.getString(3);
					cob = new CommonBean(bid, title,cname);
                    list.add(cob);
				}
				cob.setList(list);
				request.setAttribute("coombeanwithcid", cob);
				RequestDispatcher view = request
						.getRequestDispatcher("BooksSpecificCategory.jsp");
				view.forward(request, response);	
			}
			else if (request.getParameter("aid") != null)
			{
				Statement stmt = con.createStatement();
				String sql1 = "select B1.BID,B1.TITLE,A1.NAME,A1.LASTNAME,A1.BIRTHDAY from BOOKS B1,AUTHOR A1 WHERE B1.AID=A1.AID AND A1.AID="
						+ Integer.parseInt(request.getParameter("aid"));
				ResultSet rs = stmt.executeQuery(sql1);

				CommonBean cob = null;
				ArrayList list=new ArrayList();
				while (rs.next()) {
					int bid = rs.getInt(1);
					String title = rs.getString(2);
                    String name= rs.getString(3);
                    String lname=rs.getString(4);
                    java.util.Date date = rs.getDate(5);
					cob = new CommonBean(bid, title,name,lname,date);
                    list.add(cob);
				}
				cob.setList(list);
				request.setAttribute("coombeanwithaid", cob);
				RequestDispatcher view = request
						.getRequestDispatcher("BooksSpecificAuthor.jsp");
				view.forward(request, response);
			}
			else {
				Statement stmt = con.createStatement();
				String sql1 = "select * from BOOKS";
				ResultSet rs = stmt.executeQuery(sql1);
				ArrayList<BookBean> list = new ArrayList<BookBean>();
				BookBean bookbean = null;
				while (rs.next()) {
					int bid = rs.getInt(1);
					String title = rs.getString(2);
					int cid = rs.getInt(3);
					int aid = rs.getInt(4);

					bookbean = new BookBean(bid, title, cid, aid);
					list.add(bookbean);

				}
				if(bookbean!=null)
				{
				bookbean.setBooksList(list);
				}
				request.setAttribute("bookbean", bookbean);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("books.jsp");
				dispatcher.forward(request, response);
			}
        }catch(Exception e)
        {
        	e.printStackTrace();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String re=request.getParameter("bookhidden");
		System.out.println(re);
		String driver="oracle.jdbc.driver.OracleDriver";  
        
        try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			
			System.out.println("ClassNotFound");
		}
		if (request.getParameter("bookcreate") != null
				&& request.getParameter("bookcreate").equalsIgnoreCase(
						"bookcreate")) {
			try {
				Connection con = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM",
						"abc123");
				PreparedStatement pstmt3 = con
						.prepareStatement("INSERT INTO Books values(?,?,?,?)");
				pstmt3.setInt(1, Integer.parseInt(request.getParameter("bid")));
				pstmt3.setString(2, request.getParameter("title"));
				BookBean bean=(BookBean)getServletContext().getAttribute("dropdowncatbean");
				BookBean view=(BookBean)getServletContext().getAttribute("dropdownaaidbean");
				ArrayList catlist=bean.getCategoryList();
				bean=(BookBean) catlist.get(Integer.parseInt(request.getParameter("categorydropdown")));
				ArrayList aidlist=view.getAuthorList();
				view=(BookBean) aidlist.get(Integer.parseInt(request.getParameter("authordropdown")));
				System.out.println("categorydropdown----->"+bean.getCid());
				pstmt3.setInt(3,bean.getCid());
				System.out.println("authordropdown----->"+view.getAid());
				pstmt3.setInt(4,view.getAid());
				pstmt3.executeUpdate();
				System.out.println("Book created");
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("createBook.jsp");
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (re != null && re.equals("bookcreationform")) {

			try {
				Connection con = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM",
						"abc123");
				
				System.out.println("Connection Successfull");
				PreparedStatement pstmt1 = con
						.prepareStatement("INSERT INTO CATEGORY VALUES(?,?)");
				pstmt1.setInt(1, Integer.parseInt(request.getParameter("cid")));
				pstmt1.setString(2, request.getParameter("cname"));
				boolean b1=pstmt1.execute();
				request.setAttribute("b1", b1);
				System.out.println("categoruy created");
				PreparedStatement pstmt2 = con
						.prepareStatement("INSERT INTO AUTHOR VALUES(?,?,?,?)");
				pstmt2.setInt(1, Integer.parseInt(request.getParameter("aid")));
				pstmt2.setString(2, request.getParameter("aname"));
				pstmt2.setString(3, request.getParameter("alname"));

				request.getParameter("abithdate");
				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				try {
					date = formatter.parse(request.getParameter("abithdate"));
				} catch (ParseException e) {

					e.printStackTrace();
				}
				java.sql.Date sqlDate = new java.sql.Date(date.getDate());

				pstmt2.setDate(4, sqlDate);
				boolean b2=pstmt2.execute();
				request.setAttribute("b2", b2);
				System.out.println("author created");
				PreparedStatement pstmt3 = con
						.prepareStatement("INSERT INTO Books values(?,?,?,?)");
				pstmt3.setInt(1, Integer.parseInt(request.getParameter("bid")));
				pstmt3.setString(2, request.getParameter("title"));
				pstmt3.setInt(3, Integer.parseInt(request.getParameter("cid")));
				pstmt3.setInt(4, Integer.parseInt(request.getParameter("aid")));
				boolean b3=pstmt3.execute();
				request.setAttribute("b3", b3);
				System.out.println("Book created");
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("create.jsp");
				dispatcher.forward(request, response);
				// con.commit();
				// con.setAutoCommit(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		
		else {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("create.jsp");
			dispatcher.forward(request, response);
		}
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getParameter("bidsend"));
		String driver="oracle.jdbc.driver.OracleDriver";  
        
        try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			
			System.out.println("ClassNotFound");
		}
        try {
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","abc123");
			System.out.println("Connection Successfull");
				
				PreparedStatement pstmt1=con.prepareStatement("delete from books where bid=?");
				pstmt1.setInt(1,Integer.parseInt(request.getParameter("id")));
				pstmt1.executeUpdate();
				
				Statement stmt=con.createStatement();
				String sql1="select * from BOOKS";
			    ResultSet rs=stmt.executeQuery(sql1);
			    ArrayList<BookBean> list=new ArrayList<BookBean>();
			    BookBean bookbean=null;
			    while(rs.next())
			    {
			       int bid=rs.getInt(1);
			       String title=rs.getString(2);
			       int cid=rs.getInt(3);
			       int aid=rs.getInt(4);
			      
			       bookbean=new BookBean(bid, title, cid, aid);
			       list.add(bookbean);
			       
			       
			    }
				bookbean.setBooksList(list);
				request.setAttribute("bookbean", bookbean);
				RequestDispatcher dispatcher=request.getRequestDispatcher("books.jsp");
				dispatcher.forward(request, response);
        }catch(Exception e)
        {
        	
        }
	}

	
}
