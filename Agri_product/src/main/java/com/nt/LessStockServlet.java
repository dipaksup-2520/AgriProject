package com.nt;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.entity.Product;

public class LessStockServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  
	        int sto = Integer.parseInt(req.getParameter("stock"));
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/agri","root","dipak@1234");
			PreparedStatement ps=conn.prepareStatement("SELECT MIN(stock) FROM product WHERE stock=? ");
			ps.setInt(1, sto);
			ResultSet rs = ps.executeQuery();
			res.setContentType( "text/html" );

			PrintWriter pw = res.getWriter();

			List<Product> list = new ArrayList<>();

			while ( rs.next() ) {
				int id = rs.getInt( "id" );
				String name = rs.getString( "name" );
				int batch = rs.getInt( "batch" );
				int price = rs.getInt( "batch" );
				int stock = rs.getInt( "stock" );
				String type = rs.getString( "type" );
				Product p=new Product(id, name,batch, price, stock, type);
				list.add( p );
			}
			req.setAttribute( "ProList", list );
			RequestDispatcher rd = req.getRequestDispatcher( "SelectAllProduct.jsp" );
			rd.forward( req, res );
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}

}
