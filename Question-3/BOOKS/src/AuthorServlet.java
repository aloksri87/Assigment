

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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

import books.Author;
import books.BookBean;
import books.CommonBean;

/**
 * Servlet implementation class AuthorServlet
 */
@WebServlet("/AuthorServlet")
public class AuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String driver = "oracle.jdbc.driver.OracleDriver";

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {

			System.out.println("ClassNotFound");
		}
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM",
					"abc123");
			if (request.getParameter("homesend") != null
					&& request.getParameter("homesend")
							.equalsIgnoreCase("home")) {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("Home.jsp");
				dispatcher.forward(request, response);

			} else if (request.getParameter("aidsend") != null) {
				this.doDelete(request, response);
			}

			else if (request.getParameter("id") != null) {
				System.out.println("insid athrid" + request.getParameter("id"));
				Statement stmt = con.createStatement();
				String sql1 = "select A1.AID,A1.NAME,A1.LASTNAME,A1.BIRTHDAY from Author A1 WHERE A1.AID="
						+ Integer.parseInt(request.getParameter("id"));
				ResultSet rs = stmt.executeQuery(sql1);

				Author authordetailbean = null;
				ArrayList<Author> list = new ArrayList<Author>();
				while (rs.next()) {
					int aid = rs.getInt(1);
					String name = rs.getString(2);
					String lastname = rs.getString(3);
					Date date = rs.getDate(4);

					authordetailbean = new Author(aid, name, lastname, date);
					list.add(authordetailbean);

				}
				request.setAttribute("authordetailbean", authordetailbean);
				RequestDispatcher view = request
						.getRequestDispatcher("AuthorDetail.jsp");
				view.forward(request, response);
			} else {

				System.out.println("Connection Successfull");
				Statement stmt = con.createStatement();
				String sql1 = "select * from Author";
				ResultSet rs = stmt.executeQuery(sql1);
				ArrayList<Author> list = new ArrayList<Author>();
				Author authorbean = null;
				while (rs.next()) {
					int aid = rs.getInt(1);
					String name = rs.getString(2);
					String lastname = rs.getString(3);
					Date date = rs.getDate(4);

					authorbean = new Author(aid, name, lastname, date);
					list.add(authorbean);

				}
				if(authorbean!=null)
				{
				authorbean.setList(list);
				}
				request.setAttribute("authorbean", authorbean);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("author.jsp");
				dispatcher.forward(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String driver="oracle.jdbc.driver.OracleDriver";  
        
        try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			
			System.out.println("ClassNotFound");
		}
        if(request.getParameter("updateAuthor")!=null && request.getParameter("updateAuthor").equalsIgnoreCase("updateAuthor") )
        {
        	if(request.getParameter("editaid")!=null && request.getParameter("editaname")!=null && request.getParameter("editalname")!=null && request.getParameter("editabithdate")!=null)
        	{
        		try
        		{
        		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","abc123");
            	PreparedStatement pstmt2=con.prepareStatement("update AUTHOR set NAME=?,LASTNAME=?,BIRTHDAY=? where AID=?");
    			
            	pstmt2.setString(1,request.getParameter("editaname"));
            	pstmt2.setString(2,request.getParameter("editalname"));
    			
    			java.util.Date date1 = new java.util.Date();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				System.out.println("BDAY--------"+date1+"--"+request.getParameter("editabithdate"));
				try {
					date1 = formatter.parse(request.getParameter("editabithdate"));
					System.out.println("dateeeeeeee"+date1);
				} catch (ParseException e) {

					e.printStackTrace();
				}
				java.sql.Date  sqlDate = new java.sql.Date(date1.getYear(),date1.getMonth(),date1.getDate());
                
				System.out.println("sqlDate-----"+sqlDate.toString());
				pstmt2.setDate(3, sqlDate);
    			
				pstmt2.setInt(4, Integer.parseInt(request.getParameter("editaid")));
    			int result=pstmt2.executeUpdate();
    			PreparedStatement pstmt3=con.prepareStatement("select aid,name,lastname,birthday from author where aid=?");
    			pstmt3.setInt(1,Integer.parseInt(request.getParameter("editaid")));
    			ResultSet rs=pstmt3.executeQuery();
    			int valaid=0;
    			String valname=null;
    			String vallastname=null;
    			java.util.Date valdate=null;
    			while(rs.next())
    			{
    				valaid=rs.getInt(1);
    				valname=rs.getString(2);
    				vallastname=rs.getString(3);
    				valdate=rs.getDate(4);
    			}
    			request.setAttribute("editaid", valaid);
    			request.setAttribute("editafname", valname);
                request.setAttribute("editalname", vallastname);
    			request.setAttribute("editadob", valdate);
    			
    			
    			RequestDispatcher dispatcher=request.getRequestDispatcher("EditAuthorAcknowledge.jsp");
            	dispatcher.forward(request, response);
            	}catch(Exception e)
            	{
            		e.printStackTrace();
            	}
        	}
        	
        }
        else if(request.getParameter("editauthid")!=null && request.getParameter("editauthfname")!=null && request.getParameter("editauthlname")!=null && request.getParameter("editauthdob")!=null)
        {
        	request.setAttribute("editauthid", request.getParameter("editauthid"));
        	request.setAttribute("editauthfname", request.getParameter("editauthfname"));
        	request.setAttribute("editauthlname", request.getParameter("editauthlname"));
        	request.setAttribute("editauthdob", request.getParameter("editauthdob"));
        	RequestDispatcher dispatcher=request.getRequestDispatcher("EditAuthor.jsp");
        	dispatcher.forward(request, response);
        }
        
        else if(request.getParameter("authorhidden")!=null && request.getParameter("authorhidden").equalsIgnoreCase("authorcreationform") ){
        try {
        	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","abc123");
        	PreparedStatement pstmt2=con.prepareStatement("INSERT INTO AUTHOR VALUES(?,?,?,?)");
			pstmt2.setInt(1, Integer.parseInt(request.getParameter("aid")));
			pstmt2.setString(2, request.getParameter("aname"));
			pstmt2.setString(3, request.getParameter("alname"));
			
			
			
			    Date date = new Date();
		        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		        try {
		            date = formatter.parse(request.getParameter("abithdate"));
		        } catch (ParseException e) {

		            e.printStackTrace();
		        }
		        java.sql.Date sqlDate = new java.sql.Date(date.getYear(),date.getMonth(),date.getDay());
			
			pstmt2.setDate(4,sqlDate) ;
			int result=pstmt2.executeUpdate();
			request.setAttribute("result", result);
			System.out.println("aurrrrrrrrrrrrrr created");
			RequestDispatcher dispatcher=request.getRequestDispatcher("createAuthor.jsp");
			dispatcher.forward(request, response);
		   // con.commit();
		   // con.setAutoCommit(true);
	}catch(Exception e)
	{
		e.printStackTrace();
	}}else
    {
RequestDispatcher dispatcher=request.getRequestDispatcher("createAuthor.jsp");
dispatcher.forward(request, response);}
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String driver = "oracle.jdbc.driver.OracleDriver";

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {

			System.out.println("ClassNotFound");
		}
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM", "abc123");
			System.out.println("Connection Successfull");

			PreparedStatement pstmt1 = con
					.prepareStatement("delete from author where aid=?");
			pstmt1.setInt(1, Integer.parseInt(request.getParameter("aidsend")));
			pstmt1.executeUpdate();

			Statement stmt = con.createStatement();
			String sql1 = "select * from author";
			ResultSet rs = stmt.executeQuery(sql1);
			ArrayList<Author> list = new ArrayList<Author>();
			Author authorbean = null;
			while (rs.next()) {
				int bid = rs.getInt(1);
				String fname = rs.getString(2);
				String lname = rs.getString(3);
				Date bday = rs.getDate(4);

				authorbean = new Author(bid, fname, lname, bday);
				list.add(authorbean);

			}
			authorbean.setList(list);
			request.setAttribute("authorbean", authorbean);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("author.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
  e.printStackTrace();
		}
	}
}
