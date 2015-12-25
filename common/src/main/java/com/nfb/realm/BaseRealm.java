package com.nfb.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.realm.Realm;

/**
 * 类名：com.nfb.realm.BaseRealm
 * 创建者： 邓风森 .
 * 创建时间：2015/12/24
 */
public abstract class BaseRealm implements Realm {

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        return null;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return false;
    }
}
