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
@WebServlet("/addlink")
public class addpass extends HttpServlet {

	Connection con;
	
	@Override
	public void init() throws ServletException {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/buspass","root","Vitthal@123");
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
		String start=req.getParameter("startplase");
		String end=req.getParameter("endplace");
		String dob=req.getParameter("customerdob");
		//parsing
		int sid=Integer.parseInt(id);
		
		PreparedStatement pstmt=null;
		
		String query="insert into buspass_info value(?,?,?,?,?,?)";
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1,sid);
			pstmt.setString(2,name);
			pstmt.setString(3,price);
			pstmt.setString(4,start);
			pstmt.setString(5,end);
			pstmt.setString(6,dob);
			int count=pstmt.executeUpdate();
			PrintWriter pw=resp.getWriter();
			pw.print(count+"record insert sucessfully"+"<>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
