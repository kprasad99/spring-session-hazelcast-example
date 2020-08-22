package io.github.kprasad99.orm.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "TBL_USERS")
@Getter
@Setter
@ConfigurationProperties(prefix = "user")
public class User {

	@Id
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private Boolean accountNonExpired = true;
	private Boolean accountNonLocked = true;
	private Boolean credentialsNonExpired = true;
	private boolean enabled = true;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "username")
	private Set<GrantedAuthority> authorities;
}
