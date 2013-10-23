

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import books.Category;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServlet() {
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
			
			if (request.getParameter("homesend") != null
					&& request.getParameter("homesend")
							.equalsIgnoreCase("home")) {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("Home.jsp");
				dispatcher.forward(request, response);

			} else if (request.getParameter("cidsend") != null) {
				this.doDelete(request, response);
			}

			else if (request.getParameter("id") != null) {
				Connection con = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM",
						"abc123");
				System.out.println("insid athrid" + request.getParameter("id"));
				Statement stmt = con.createStatement();
				String sql1 = "select CID,NAME from Category WHERE CID="
						+ Integer.parseInt(request.getParameter("id"));
				ResultSet rs = stmt.executeQuery(sql1);

				Category categorydetailbean = null;
				ArrayList<Category> list = new ArrayList<Category>();
				while (rs.next()) {
					int cid = rs.getInt(1);
					String name = rs.getString(2);

					categorydetailbean = new Category(cid, name);
					list.add(categorydetailbean);

				}
				request.setAttribute("categorydetailbean", categorydetailbean);
				RequestDispatcher view = request
						.getRequestDispatcher("categoryDetail.jsp");
				view.forward(request, response);
			} else {
				Connection con = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM",
						"abc123");
				System.out.println("Connection Successfull");
				Statement stmt = con.createStatement();
				String sql1 = "select * from Category";
				ResultSet rs = stmt.executeQuery(sql1);
				ArrayList<Category> list = new ArrayList<Category>();
				Category categorybean = null;
				while (rs.next()) {
					int aid = rs.getInt(1);
					String name = rs.getString(2);
					categorybean = new Category(aid, name);
					list.add(categorybean);

				}
				if(categorybean!=null)
				{
				categorybean.setList(list);
				}
				request.setAttribute("categorybean", categorybean);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("category.jsp");
				dispatcher.forward(request, response);

			}} catch (Exception e) {
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
        if(request.getParameter("aid")!=null && request.getParameter("aname")!=null)
        {
        	System.out.println(request.getParameter("aid"));
        	int editid=Integer.parseInt(request.getParameter("aid"));
        	String editname=request.getParameter("aname");
        	
        	System.out.println(editid +" "+editname);
        	try
        	{
        	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","abc123");
        	PreparedStatement pstmt2=con.prepareStatement("update CATEGORY set NAME=? where CID=?");
			
        	pstmt2.setString(1,editname);
			pstmt2.setInt(2, editid);
			
			
			int result=pstmt2.executeUpdate();
			PreparedStatement pstmt3=con.prepareStatement("select cid,name from CATEGORY where CID=?");
			pstmt3.setInt(1,editid);
			ResultSet rs=pstmt3.executeQuery();
			int valcid=0;
			String valname=null;
			while(rs.next())
			{
				valcid=rs.getInt("cid");
				valname=rs.getString("name");
			}
			request.setAttribute("editid", valcid);
			
			request.setAttribute("editname", valname);
			System.out.println(valcid);
			System.out.println(valname);
			RequestDispatcher dispatcher=request.getRequestDispatcher("EditCategoryAcknowledge.jsp");
        	dispatcher.forward(request, response);
        	}catch(Exception e)
        	{
        		e.printStackTrace();
        	}
        	
        }
		
        else if(request.getParameter("editcatid")!=null && request.getParameter("editcatname")!=null)
        {
        	request.setAttribute("editcatid", request.getParameter("editcatid"));
        	request.setAttribute("editcatname", request.getParameter("editcatname"));
        	RequestDispatcher dispatcher=request.getRequestDispatcher("EditCategory.jsp");
        	dispatcher.forward(request, response);
        }
        else if(request.getParameter("categoryhidden")!=null && request.getParameter("categoryhidden").equalsIgnoreCase("categoryhidden") ){
        try {
        	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","abc123");
        	PreparedStatement pstmt2=con.prepareStatement("INSERT INTO CATEGORY VALUES(?,?)");
			pstmt2.setInt(1, Integer.parseInt(request.getParameter("caid")));
			pstmt2.setString(2, request.getParameter("caname"));
			
			boolean result=pstmt2.execute();
			request.setAttribute("result", result);
			System.out.println("Category  created");
			
		   // con.commit();
		   // con.setAutoCommit(true);
			RequestDispatcher dispatcher=request.getRequestDispatcher("createCategory.jsp");
			dispatcher.forward(request, response);
	}catch(SQLException e)
	{ 
		String str=e.getMessage();
		String[] str1=str.split(":");
		System.out.println(str1[0]);
		if(str1[0].equalsIgnoreCase("ORA-00001"))
		{
			request.setAttribute("Idexist","Idexist");
			RequestDispatcher dispatcher=request.getRequestDispatcher("createCategory.jsp");
			dispatcher.forward(request, response);
		}
		else
		e.printStackTrace();
	}}else
    {
RequestDispatcher dispatcher=request.getRequestDispatcher("createCategory.jsp");
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
					.prepareStatement("delete from category where cid=?");
			pstmt1.setInt(1, Integer.parseInt(request.getParameter("cidsend")));
			pstmt1.executeUpdate();

			Statement stmt = con.createStatement();
			String sql1 = "select * from category";
			ResultSet rs = stmt.executeQuery(sql1);
			ArrayList<Category> list = new ArrayList<Category>();
			Category categorybean = null;
			while (rs.next()) {
				int bid = rs.getInt(1);
				String name = rs.getString(2);
				

				categorybean = new Category(bid, name);
				list.add(categorybean);

			}
			categorybean.setList(list);
			request.setAttribute("categorybean", categorybean);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("category.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
  e.printStackTrace();
		}
	}
}
