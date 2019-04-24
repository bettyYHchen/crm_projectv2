package com.busyqa.crm.services;


import java.util.Collection;


import com.busyqa.crm.pojo.CrmUser;
import com.busyqa.crm.repositories.CrmUserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CrmUserRepository crmUserRepository;




    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        CrmUser crmUser = this.crmUserRepository.findByUserName(userName);

        if (crmUser == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }

        System.out.println("Found User: " + crmUser);

        UserDetails userDetails = (UserDetails) new User(crmUser.getUserName(), //
                crmUser.getEncryptedPassword(), getAuthorities(crmUser));

        return userDetails;
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(CrmUser crmUser) {
        String[] userRoles = crmUser.getRoles().stream().map((role) -> role.getRoleName()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }
}


