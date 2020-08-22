package io.github.kprasad99.orm.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_USER_ROLES")
@Getter
@Setter
public class GrantedAuthority {

	@Id
	@Column(name="user_role_id")
	private int id;
	private String role;
	private String username;
}
