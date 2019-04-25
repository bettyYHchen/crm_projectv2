package com.busyqa.crm.pojo;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserRest {
    private String username;
    private Collection<? extends GrantedAuthority> authorities;

    public UserRest() {
    }

    public UserRest(String username, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.authorities = authorities;
    }

    public String getUsername() {
        return username;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
