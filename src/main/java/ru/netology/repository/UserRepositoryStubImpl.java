package ru.netology.repository;

import java.util.List;

import ru.netology.authority.Authorities;
import ru.netology.model.Account;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Arrays;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryStubImpl implements UserRepository {

	private ConcurrentMap<String, Account> repo;

	private static AtomicLong nextId = new AtomicLong();

	public UserRepositoryStubImpl() {
		this.repo = new ConcurrentHashMap<>();
	}
	private long getNextId() {
	 return nextId.incrementAndGet();
	}

	public Account save(long userId, String user, String password, List<Authorities> authorities) {
		Account account = new Account(userId, user, password, authorities);
		if (userId == 0) {
			userId = getNextId();
			repo.put(user, account);
		} else {
			repo.put(user, account);
		}
		return account;
	}

	public List<Authorities> getUserAuthorities(String user, String password) {
		Account account = repo.get(user);
		List<Authorities> authorities = account.getAuthorities();
		/*
		 * if (account.getUser() == user && account.getPassword() == password ) {
		 * authorities = account.getAuthorities();
		 * } else {
		 * authorities = null;
		 * }
		 */
		//return authorities;
		List<Authorities> al = Arrays.asList(Authorities.valueOf("READ"), Authorities.valueOf("WRITE"),
				Authorities.valueOf("DELETE"));
		return al;
	}
}
