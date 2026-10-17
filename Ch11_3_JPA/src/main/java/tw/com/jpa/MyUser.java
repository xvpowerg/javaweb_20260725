package tw.com.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(name="findMyUser",query="SELECT myUserObj FROM MyUser  myUserObj WHERE "+
				"myUserObj.account = :account and myUserObj.password =:password")
	
})
@Entity
public class MyUser {
	@Id
	@GeneratedValue
	private int id;
	private String account;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "MyUser [id=" + id + ", account=" + account + ", password=" + password + "]";
	}
	
	
	
}
