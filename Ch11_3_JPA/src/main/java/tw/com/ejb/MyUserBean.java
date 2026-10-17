package tw.com.ejb;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import tw.com.jpa.MyUser;

@Stateless
public class MyUserBean implements MyUserBeanLocal  {
	@Inject
	private EntityManager em;

	@Override
	public boolean login(MyUser myUser) {
		// TODO Auto-generated method stub
		 MyUser lgoin = 
				 findUserByAccount(myUser.getAccount(), myUser.getPassword());
		 
		return lgoin != null;
	}

	@Override
	public boolean regisrter(MyUser myUser) {
		// TODO Auto-generated method stub
		try {
				em.persist(myUser);
				return true;
		}catch(Exception ex) {
			System.out.println("regisrter error"+ex);
		}
		return false;
	}

	@Override
	public MyUser findUserByAccount(String account, String password) {
		// TODO Auto-generated method stub
		TypedQuery<MyUser> query=  em.createNamedQuery("findMyUser",MyUser.class);
		query.setParameter("account", account);
		query.setParameter("password", password);
		try {
			MyUser myUser =   query.getSingleResult();
			return myUser;
		}catch(Exception ex) {
			System.out.println("findUserByAccount:"+ex);
			return null;
		}
		
			
		
	}

	@Override
	public boolean deleteUser(MyUser myUser) {
		try {
			MyUser newMyUser =  em.merge(myUser);
			// TODO Auto-generated method stub
			em.remove(newMyUser);
			return true;
		}catch(Exception ex) {
			System.out.println("deleteUser:"+ex);
		}

		return false;
	}

	@Override
	public boolean updateUser(MyUser myUser) {
		// TODO Auto-generated method stub
		try {
			em.merge(myUser);
			return true;
		}catch(Exception ex) {
			System.out.println("UpdateUser:"+ex);
		}
		
		return false;
	}
	
	
	
}
