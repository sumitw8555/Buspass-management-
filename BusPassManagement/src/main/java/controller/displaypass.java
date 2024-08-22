package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;
@WebServlet("/display")
public class displaypass extends HttpServlet {
	
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
    	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
	Statement stmt=null;
			ResultSet rs=null;
			PrintWriter pw=resp.getWriter();
			String query="select * from buspass_info";
			
			try {
				stmt=con.createStatement();
				rs=stmt.executeQuery(query);
				pw.print("<table border='2'>");
				pw.print("<tr>");
				pw.print("<th> Pass Id </th>");
				pw.print("<th> Customer Name </th>");
				pw.print("<th>  Pass Price </th>");
				pw.print("<th>  start place </th>");
				pw.print("<th>  End Pleace </th>");
				pw.print("<th> customer birthdate </th>");
				pw.print("</tr>");
				while(rs.next()) {
					int id=rs.getInt(1);
					String name=rs.getString(2);
					String price=rs.getString(3);
					String start=rs.getString(4);
					String end=rs.getString(5);
					String dob=rs.getString(6);
							pw.print("<tr>");
							pw.print("<td>"+id+"</td>");
							pw.print("<td>"+name+"</td>");
							pw.print("<td>"+price+"</td>");
							pw.print("<td>"+start+"</td>");
							pw.print("<td>"+end+"</td>");
							pw.print("<td>"+dob+"</td>");
							pw.print("<tr>");
							
							
							pw.print("<button style='color:red' onclick='window.print()'>print"+"</button>"); 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
