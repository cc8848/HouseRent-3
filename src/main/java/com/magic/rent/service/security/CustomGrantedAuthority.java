package com.magic.rent.service.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wuxinzhe   创建时间: 16/10/6
 * 类说明:
 */
public class CustomGrantedAuthority implements GrantedAuthority, Serializable {

    private static final long serialVersionUID = 9188347583387457302L;

    private final String authority;

    public CustomGrantedAuthority(String role) {
        Assert.hasText(role, "A granted authority textual representation is required");
        this.authority = role;
    }

    public String getAuthority() {
        return authority;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof CustomGrantedAuthority) {
            return authority.equals(((CustomGrantedAuthority) obj).authority);
        }

        return false;
    }

    public int hashCode() {
        return this.authority.hashCode();
    }

    public String toString() {
        return this.authority;
    }
}
