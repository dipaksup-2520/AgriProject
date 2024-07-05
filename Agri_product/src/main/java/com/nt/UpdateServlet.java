package com.nt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			int id=Integer.parseInt(req.getParameter("id"));
			int price=Integer.parseInt(req.getParameter("price"));
			try {
				Class.forName( "com.mysql.jdbc.Driver" );
				Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/agri", "root", "dipak@1234" );
				PreparedStatement ps=con.prepareStatement("update product set price=? where id=?");
				ps.setInt(2, id);
				ps.setInt(1, price);
			    ps.executeUpdate();
				
				
			} catch (Exception e) {	
				
				e.printStackTrace();
			}
			res.setContentType("text/html");
			PrintWriter pw=res.getWriter();
			pw.write("<h1> upadate successfull");
			pw.close();
			
	}

}