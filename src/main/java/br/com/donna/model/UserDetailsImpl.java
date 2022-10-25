package br.com.donna.model;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {

	private Usuario usuario;

	public UserDetailsImpl(Usuario usuario) {
		this.usuario = usuario;
	
	}
	

	/*
	 * @Override public Collection<? extends GrantedAuthority> getAuthorities() {
	 * Perfil perfil = usuario.getCargo().getNome().equals("Gerente") ?	 * Perfil.ADMIN : Perfil.USER;
	 * 
	 * return AuthorityUtils.createAuthorityList(perfil.toString()); }
	 */

	@Override
	public String getPassword() {
		return usuario.getSenha();
	}

	@Override
	public String getUsername() {
		return usuario.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
	    return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			// TODO Auto-generated method stub
			return null;
	}
}
