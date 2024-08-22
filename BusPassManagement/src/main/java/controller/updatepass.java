package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/updatelink")
public class updatepass extends HttpServlet{
	
Connection con;
	
	@Override
	public void init() throws ServletException {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/buspass ? user=root & password=Vitthal@123");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id=req.getParameter("passid");
		String name=req.getParameter("customername");
		String price=req.getParameter("passprice");
		String start=req.getParameter("startplace");
		String end=req.getParameter("endplace");
		String dob=req.getParameter("customerdob");
		//parsing
		int sid=Integer.parseInt(id);
		
		PreparedStatement pstmt=null;
		
		String query="update buspass_info set customername=?, passprice=?, startplace=?, endplace=?, customerdob=? where passid=?";
		
		try {
			pstmt=con.prepareStatement(query); 
			pstmt.setInt(6,sid);
			pstmt.setString(1,name);
			pstmt.setString(2,price);
			pstmt.setString(3,start);
			pstmt.setString(4,end);
			pstmt.setString(5,dob);
			int count=pstmt.executeUpdate();
			PrintWriter pw=resp.getWriter();
			pw.print(count+"record update sucessfully"); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
