package com.highspot.authgateway.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String clientId) throws UsernameNotFoundException {
//        OAuthUsers user = new OAuthUsers();
//        user.setClientSecret("password");
//        user.setClientId("user");
//        user.setRoles(new ArrayList<>(Arrays.asList("USER", "ADMIN")));
//        OAuthUsers uu = userRepository.save(user);

        OAuthUsers oauth2User = userRepository.findByClientId(clientId);
        if(oauth2User != null) {

            List<GrantedAuthority> authorities = oauth2User.getRoles().stream().map(role ->
                    new SimpleGrantedAuthority("ROLE_" + role)).collect(Collectors.toList());

            return new User(oauth2User.getClientId(), "{noop}" + oauth2User.getClientSecret(), authorities);
        } else {
            throw new UsernameNotFoundException("username not found");
        }
    }

//    public OAuthUsers findUserByClientId(String clientId) {
//        return userRepository.findByClientId(clientId);
//    }
//
//    public void saveUser(OAuthUsers user) {
//        user.setClientSecret(user.getClientSecret());
//        user.setEnabled(true);
//
//        user.setRoles(new HashSet<String>(Arrays.asList("ADMIN", "USER")));
//        userRepository.save(user);
//    }
}
