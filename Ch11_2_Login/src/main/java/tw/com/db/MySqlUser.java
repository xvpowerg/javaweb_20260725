package tw.com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tw.com.web.WebDbTools;

public class MySqlUser implements UserDao {

	@Override
	public boolean login(String account, String password) {
		// TODO Auto-generated method stub
		String sql = "SELECT  COUNT(*)  FROM my_user WHERE account = ? and password = ?";
		try(Connection conn =  WebDbTools.getConnection();
				PreparedStatement stm = conn.prepareStatement(sql);){
			stm.setString(1, account);
			stm.setString(2, password);
			ResultSet result =  stm.executeQuery();
			result.next();
			return result.getInt(1) > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean regisrter(String account, String password) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO my_user(account,password) VALUES(?,?)";
		try(Connection conn =  WebDbTools.getConnection();
				PreparedStatement stm = conn.prepareStatement(sql);){
			stm.setString(1, account);
			stm.setString(2, password);
			int  count =  stm.executeUpdate();
			return count > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return false;
	}

}
