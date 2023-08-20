package md.brainet.chat.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import md.brainet.chat.dao.interfaces.UserReader;
import md.brainet.chat.entity.User;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserReader userReader;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String nick) throws UsernameNotFoundException {
		User user = userReader.getUserByUserNick(nick);
		if(user == null) {
			throw new UsernameNotFoundException("User doesn't exist");
		}
		return new org.springframework.security.core.userdetails
				.User(user.getNick(), 
						user.getPassword(),
						new ArrayList<GrantedAuthority>());
	}
	
}
