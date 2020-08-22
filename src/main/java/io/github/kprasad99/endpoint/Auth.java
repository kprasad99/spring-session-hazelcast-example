package io.github.kprasad99.endpoint;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.kprasad99.orm.dao.UserDao;
import io.github.kprasad99.orm.domain.User;

@RestController
@RequestMapping("/api/auth")
public class Auth {

	@Autowired
	private UserDao userDao;

	@GetMapping(path = "/login")
	public Optional<User> login(Principal principal) {
		return userDao.findById(principal.getName()).map(e -> {
			e.setPassword(null);
			return e;
		});
	}

	@GetMapping(path = "/logout")
	public boolean logout() {
		SecurityContextHolder.clearContext();
		return true;
	}
}