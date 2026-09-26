package tw.com.web;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = "測試食品";
		int price = 10;
		int sotck = 25;
		String url = "jdbc:mysql://localhost:3306/shop_lesson1?serverTimezone=Asia/Taipei&useSSL=false&allowPublicKeyRetrieval=true";
		String user = "root";
		String password = "123456";
		try(Connection conn = 
				DriverManager.getConnection(url,user,password);
				Statement stem = conn.createStatement();){
			//int count = stem.executeUpdate("INSERT INTO product(name,price,stock) VALUES('原味牛肉堡',35,18)");
			int count = stem.executeUpdate("INSERT INTO product(name,price,stock) "
					+ "VALUES('"+name+"',"+price+","+sotck+")");
			System.out.println(count);
		}catch(SQLException ex) {
			ex.printStackTrace();
			System.out.print(ex.fillInStackTrace());
		}
		
	}
}
