package org.iesalixar.dfernandezs.proyecto.service;

import java.util.HashSet;
import java.util.Set;

import org.iesalixar.dfernandezs.proyecto.model.Authority;
import org.iesalixar.dfernandezs.proyecto.model.User;
import org.iesalixar.dfernandezs.proyecto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService{
	
	
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		User user = repo.findByUsername(username);
		
		if (user == null) throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Authority auth : user.getAuthority()){
            grantedAuthorities.add(new SimpleGrantedAuthority(auth.getAuthority()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);

	}
	
	public User addUser(User user) {
		return repo.save(user);	
	}
	
	public User updateUser(User fromUser) {
		User toUser = repo.findByUsername(fromUser.getUsername());
		toUser.setName(fromUser.getName());
		toUser.setLastName(fromUser.getLastName());
		toUser.setImage(fromUser.getImage());
		toUser.setUsername(fromUser.getUsername());
		return repo.save(toUser);
		
	}
	
}
