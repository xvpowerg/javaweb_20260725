package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/page1")
public class Page1Servlet  extends HttpServlet{
	
	private String url = "jdbc:mysql://localhost:3306/shop_lesson1?serverTimezone=Asia/Taipei&useSSL=false&allowPublicKeyRetrieval=true";
	private String user = "root";
	private String password = "123456";
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sql = "INSERT INTO product(name,price,stock) VALUES(?,?,?)";
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		String price =req.getParameter("price");
		String stock = req.getParameter("stock");
		float priceFloat = Float.parseFloat(price);
		int stockInteger = Integer.parseInt(stock);
		PrintWriter out =  resp.getWriter();
		try(Connection conn = DriverManager.getConnection(url,user,password);
			PreparedStatement stm = conn.prepareStatement(sql);){
			stm.setString(1, name);
			stm.setFloat(2, priceFloat);
			stm.setInt(3, stockInteger);
			int count = stm.executeUpdate();
			if (count > 0) {
				out.println("Pass");
			}
		}catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
					out.println("Faill");
				}
		
				
	}
}
