package ru.netology.service;

import java.util.List;
import org.springframework.stereotype.Service;

import ru.netology.repository.UserRepositoryStubImpl;
import ru.netology.authority.Authorities;
import ru.netology.exception.InvalidCredentials;
import ru.netology.exception.UnauthorizedUser;
import ru.netology.model.Account;
import ru.netology.exception.AccountNotFoundException;

@Service
public class AuthorizationService {

	UserRepositoryStubImpl userRepository;
	Account account;

	public AuthorizationService(UserRepositoryStubImpl userRepository) {
		this.userRepository = userRepository;
	}

	public List<Authorities> getAuthorities(String user, String password) {

		if (isEmpty(user) || isEmpty(password)) {
			throw new InvalidCredentials("User name or password is empty");
		}

		account = userRepository.getAccountByName(user).orElseThrow(AccountNotFoundException::new);

		if (isEmpty(account)) {
			throw new AccountNotFoundException("Unknown account " + account.toString());
		}

		List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);

		if (isEmpty(userAuthorities) || !account.getPassword().equals(password)) {
			throw new UnauthorizedUser("Unknown user " + user);
		}

		return userAuthorities;
	}

	private boolean isEmpty(String str) {
		return str == null || str.isEmpty();
	}

	private boolean isEmpty(List<Authorities> str) {
		return str == null || str.isEmpty();
	}

	private boolean isEmpty(Account account) {
		return account == null;
	}
}
