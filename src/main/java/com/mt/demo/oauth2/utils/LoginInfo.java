package com.mt.demo.oauth2.utils;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * LoginInfo
 *
 * @author MT.LUO
 * 2018/1/22 18:42
 * @Description:
 */
public class LoginInfo {

    public static UserDetails getCurrentUser() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication auth = ctx.getAuthentication();
        UserDetails user = (UserDetails) auth.getPrincipal();
        return user;
    }

    public static boolean isLogin() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication auth = ctx.getAuthentication();
        if (auth instanceof AnonymousAuthenticationToken) {
            return false;
        } else if (auth == null) {
            return false;
        } else {
            return true;
        }
    }
}
