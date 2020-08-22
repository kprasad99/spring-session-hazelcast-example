package io.github.kprasad99.orm.dao;

import io.github.kprasad99.orm.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, String> {

}
