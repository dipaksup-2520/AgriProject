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

public class AddServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		int id  = Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		int batch  = Integer.parseInt(req.getParameter("batch"));
		int price  = Integer.parseInt(req.getParameter("price"));
		int stock  = Integer.parseInt(req.getParameter("stock"));
		String type=req.getParameter("type");
		
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
			Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/agri", "root", "dipak@1234" );
			PreparedStatement ps = con.prepareStatement( "insert into product values(?,?,?,?,?,?)" );
			ps.setInt( 1, id );
			ps.setString( 2, name );
			
			ps.setInt( 3, batch);
			ps.setInt( 4, price);
			ps.setInt( 5, stock);
			ps.setString( 6, type );
			ps.executeUpdate();
		} catch ( Exception e ) {
			e.printStackTrace();
		}

		PrintWriter pw = resp.getWriter();
		pw.write("<h1> product added succses</h1>");
		pw.close();
		
	}
}
