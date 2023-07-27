package ru.netology.model;

import ru.netology.authority.Authorities;
import java.util.List;
//import org.mindrot.jbcrypt.BCrypt;



public class Account {
	//private static final String salt = BCrypt.gensalt();
	private long userId;
	private String user;
	private String password;
	private List<Authorities> authorities;

	public Account(long userId, String user, String password, List<Authorities> authorities) {
		this.userId = userId;
		this.user = user;
		//this.password = BCrypt.hashpw(password, salt);
		this.password = password;
		this.authorities = authorities;
	}

	public long getUserId() {
		return userId;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public List<Authorities> getAuthorities() {
		return authorities;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(List<Authorities> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String toString() {
		return "{ " + userId + " " + user + " " + authorities + " }";
	}
}
