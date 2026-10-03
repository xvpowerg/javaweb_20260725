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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	private String url = "jdbc:mysql://localhost:3306/shop_lesson1?serverTimezone=Asia/Taipei&useSSL=false&allowPublicKeyRetrieval=true";
	private String user = "root";
	private String password = "123456";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sql = "SELECT name,price,stock FROM product";
		try(Connection conn = DriverManager.getConnection(url,user,password);
			 Statement st = 	conn.createStatement();){
			ResultSet result = st.executeQuery(sql);
			ArrayList<Product> resultList = new ArrayList();
			while(result.next()) {
				System.out.println(result.getString(1));
				System.out.println(result.getString(2));
				System.out.println(result.getString(3));
				System.out.println("=======================");
				var p = new Product(result.getString(1),
						result.getFloat(2),
						result.getInt(3));
						
				
				
				resultList.add(p);
			}
			req.setAttribute("resultList", resultList);
			req.getRequestDispatcher("view_order.jsp").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
}
