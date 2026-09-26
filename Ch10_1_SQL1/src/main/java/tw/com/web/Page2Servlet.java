package tw.com.web;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/page2")
public class Page2Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = "香魚堡";
		int price = 10;
		int sotck = 25;
		String url = "jdbc:mysql://localhost:3306/shop_lesson1?serverTimezone=Asia/Taipei&useSSL=false&allowPublicKeyRetrieval=true";
		String user = "root";
		String password = "123456";
		String sql = "INSERT INTO product(name,price,stock) VALUES(?,?,?)";
		try(Connection conn = 
				DriverManager.getConnection(url,user,password);
				PreparedStatement stem = conn.prepareStatement(sql);){
			//int count = stem.executeUpdate("INSERT INTO product(name,price,stock) VALUES('原味牛肉堡',35,18)");
			stem.setString(1, name);
			stem.setInt(2, price);
			stem.setInt(3, sotck);
			int count = stem.executeUpdate();
			System.out.println(count);
		}catch(SQLException ex) {
			ex.printStackTrace();
			System.out.print(ex.fillInStackTrace());
		}
		//設計一份HTML輸入
		//輸入 產品名稱 金額 庫存
		//顯示 新增成功
		
	}
}
