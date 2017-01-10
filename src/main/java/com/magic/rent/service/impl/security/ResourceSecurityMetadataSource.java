package com.magic.rent.service.impl.security;

import com.magic.rent.dao.mapper.SysResourcesMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


@Service
public class ResourceSecurityMetadataSource implements FilterInvocationSecurityMetadataSource, InitializingBean {

    private final static List<ConfigAttribute> NULL_CONFIG_ATTRIBUTE = Collections.emptyList();

    //权限集合
    private Map<RequestMatcher, Collection<ConfigAttribute>> requestMap;

    private static Logger logger = LoggerFactory.getLogger(ResourceSecurityMetadataSource.class);

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
        logger.info("请求资源:{}", request.getRequestURI());
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
        Map<String, String> resourceLinkMap = new LinkedHashMap<String, String>();

        List<Map<String, String>> resourceList = sysResourcesMapper.getURLResourceMapping();

        for (Map<String, String> resourceMap : resourceList) {
            String resourcePath = resourceMap.get("resourcePath");
            String authorityMark = resourceMap.get("authorityMark");
            if (resourceLinkMap.containsKey(resourcePath)) {
                String mark = resourceLinkMap.get(resourcePath);
                resourceLinkMap.put(resourcePath, mark + "," + authorityMark);
            } else {
                resourceLinkMap.put(resourcePath, authorityMark);
            }
        }

        return resourceLinkMap;
    }

    private Map<RequestMatcher, Collection<ConfigAttribute>> bindRequestMap() {
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
        logger.info("资源文件权限参数初始化:资源列表[{}]", requestMap);
    }

    /**
     * 手动刷新资源
     */
    public void refreshResuorceMap() {
        this.requestMap = this.bindRequestMap();
    }

}
