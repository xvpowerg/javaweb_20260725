package tw.com.ejb;

import jakarta.ejb.Local;
import tw.com.jpa.MyUser;

@Local
public interface MyUserBeanLocal {
	boolean login(MyUser myUser);
	boolean regisrter(MyUser myUser);
	MyUser findUserByAccount(String account,String password);
	boolean deleteUser(MyUser myUser);
	boolean updateUser(MyUser myUser);
}
