package tw.com.db;

public interface UserDao {
	boolean login(String account,String password);
	boolean regisrter(String account,String password);
}
