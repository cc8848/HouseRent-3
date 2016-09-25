package com.magic.rent.service.security;

import com.magic.rent.mapper.SysResourcesMapper;
import com.magic.rent.util.Log;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by wuxinzhe on 16/9/25.
 */
@Service
public class URLFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource, InitializingBean {

    private final static List<ConfigAttribute> NULL_CONFIG_ATTRIBUTE = Collections.emptyList();

    //权限集合
    private Map<RequestMatcher, Collection<ConfigAttribute>> requestMap;

    @Autowired
    private SysResourcesMapper sysResourcesMapper;


    public Collection<ConfigAttribute> getAttributes(Object object)
            throws IllegalArgumentException {
        final HttpServletRequest request = ((FilterInvocation) object).getRequest();

        Collection<ConfigAttribute> attrs = NULL_CONFIG_ATTRIBUTE;

        for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap.entrySet()) {
            if (entry.getKey().matches(request)) {
                attrs = entry.getValue();
                break;
            }
        }

        Log.info(URLFilterInvocationSecurityMetadataSource.class, "获取URL资源", "URL资源：" + request.getRequestURI() + " -> " + attrs);
        return attrs;
    }

    public Collection<ConfigAttribute> getAllConfigAttributes() {
        Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();

        for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap.entrySet()) {
            allAttributes.addAll(entry.getValue());
        }

        return allAttributes;
    }

    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }

    private Map<String, String> loadResource() {
        Map<String, String> map = new LinkedHashMap<String, String>();

        List<Map<String, String>> list = this.sysResourcesMapper.getURLResourceMapping();
        Iterator<Map<String, String>> it = list.iterator();
        while (it.hasNext()) {
            Map<String, String> rs = it.next();
            String resourcePath = rs.get("resourcePath");
            String authorityMark = rs.get("authorityMark");

            if (map.containsKey(resourcePath)) {
                String mark = map.get("resourcePath");
                map.put(resourcePath, mark + "," + authorityMark);
            } else {
                map.put(resourcePath, authorityMark);
            }
        }
        return map;
    }

    protected Map<RequestMatcher, Collection<ConfigAttribute>> bindRequestMap() {
        Map<RequestMatcher, Collection<ConfigAttribute>> map =
                new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();
        Map<String, String> resMap = this.loadResource();
        for (Map.Entry<String, String> entry : resMap.entrySet()) {
            String key = entry.getKey();
            map.put(new AntPathRequestMatcher(key), SecurityConfig.createListFromCommaDelimitedString(entry.getValue()));
        }
        return map;
    }

    public void afterPropertiesSet() throws Exception {
        this.requestMap = this.bindRequestMap();
        Log.info(URLFilterInvocationSecurityMetadataSource.class, "获取权限列表", "资源权限列表" + this.requestMap);
    }

    public void refreshResuorceMap() {
        this.requestMap = this.bindRequestMap();
    }

}
