package com.restro.backend.service;

import com.restro.backend.model.user;
import com.restro.backend.repository.userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private userrepo userepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user us = userepo.findByUsername(username);
        if(us == null)
            throw new UsernameNotFoundException("User Not found");
        else
            return new UserDetails() {
                @Override
                public Collection<? extends GrantedAuthority> getAuthorities() {
                    return List.of(new GrantedAuthority() {
                        @Override
                        public String getAuthority() {
                            return "USER";
                        }
                    });
                }

                @Override
                public String getPassword() {
                    return us.getPass();
                }

                @Override
                public String getUsername() {
                    return us.getUsername();
                }
            };
    }
}
