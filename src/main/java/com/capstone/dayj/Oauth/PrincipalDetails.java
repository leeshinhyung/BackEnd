package com.capstone.dayj.Oauth;

import com.capstone.dayj.appUser.AppUser;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Getter
public class PrincipalDetails implements OAuth2User {
    private final AppUser appUser;
    private final Map<String, Object> attributes;

    public PrincipalDetails(AppUser appUser, Map<String, Object> attributes) {
        this.appUser = appUser;
        this.attributes = attributes;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add((GrantedAuthority) appUser::getRole);
        return collect;
    }

    @Override
    public String getName() {
        return appUser.getName();
    }
}