package vn.iotstar.entity;

import java.util.Collection;
import java.util.Date;

import java.util.List;


import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private Integer id;
	
	@Column(nullable = false, columnDefinition = "nvarchar(50)")
	private String fullname;
	
	
	@Column(unique = true, length = 100, nullable = false)
	private String email;
	
	@Column(columnDefinition = "nvarchar(500)", nullable = false)
	private String images;

	@Column(nullable = false)
	private String password;
	
	@CreationTimestamp
	@Column(updatable = false, name = "created_at")
	private Date createAt;
	
	@CreationTimestamp
	@Column(updatable = false, name = "updated_at")
	private Date updatedAt;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of();
	}
	
	public String getPasword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
