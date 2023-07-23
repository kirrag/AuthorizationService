package ru.netology.repository;

import ru.netology.model.Account;
import ru.netology.authority.Authorities;


import java.util.List;
import java.util.Optional;

public interface UserRepository {

	Account save(long userId, String user, String password, List<Authorities> authorities);

	List<Authorities> getUserAuthorities(String user, String password);

}
