package com.magic.rent.service.security;

import com.magic.rent.mapper.SysResourcesMapper;
import com.magic.rent.pojo.MethodKey;
import com.magic.rent.util.Log;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.method.AbstractMethodSecurityMetadataSource;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by wuxinzhe on 16/9/25.
 */
@Service
public class MethodSecurityMetadataSource extends AbstractMethodSecurityMetadataSource implements InitializingBean {
    private final static List<ConfigAttribute> NULL_CONFIG_ATTRIBUTE = Collections.emptyList();

    private final static String RES_KEY = "resourcePath";
    private final static String AUTH_KEY = "authorityMark";

    private Map<MethodKey, Collection<ConfigAttribute>> requestMap;

    @Autowired
    private SysResourcesMapper sysResourcesMapper;

    /**
     * 根据方法获取到访问方法所需要的权限
     *
     * @param method      访问的方法
     * @param targetClass 方法所属的类
     */

    public Collection<ConfigAttribute> getAttributes(Method method,
                                                     Class<?> targetClass) {
        MethodKey key = new MethodKey(method);
        Collection<ConfigAttribute> attrs = NULL_CONFIG_ATTRIBUTE;

        for (Map.Entry<MethodKey, Collection<ConfigAttribute>> entry : requestMap.entrySet()) {
            if (entry.getKey().equals(key)) {
                attrs = entry.getValue();
                break;
            }
        }

        Log.info(MethodSecurityMetadataSource.class, "获取METHOD资源", "METHOD资源：" + key.getFullMethodName() + " -> " + attrs);
        return attrs;
    }

    /**
     * 获取到所有方法对应的权限集合
     */
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();

        for (Map.Entry<MethodKey, Collection<ConfigAttribute>> entry : requestMap.entrySet()) {
            allAttributes.addAll(entry.getValue());
        }

        return allAttributes;
    }

    /**
     * 初始化方法权限对应集合，绑定方法权限集合
     */
    public void afterPropertiesSet() throws Exception {
        this.requestMap = this.bindRequestMap();
    }

    /**
     * 从数据库中获取方法及权限对应信息
     *
     * @return
     */
    private Map<String, String> loadMethod() {
        Map<String, String> resMap = new LinkedHashMap<String, String>();
        List<Map<String, String>> list = this.sysResourcesMapper.getMethodResourceMapping();

        for (Map<String, String> map : list) {
            String resourcePath = map.get(RES_KEY);
            String authorityMark = map.get(AUTH_KEY);

            if (resMap.containsKey(resourcePath)) {
                String mark = resMap.get(resourcePath);
                resMap.put(resourcePath, mark + "," + authorityMark);
            } else {
                resMap.put(resourcePath, authorityMark);
            }
        }

        return resMap;
    }

    /**
     * 封装从数据库中获取的方法权限集合
     *
     * @return
     */
    public Map<MethodKey, Collection<ConfigAttribute>> bindRequestMap() {
        Map<MethodKey, Collection<ConfigAttribute>> resMap =
                new LinkedHashMap<MethodKey, Collection<ConfigAttribute>>();

        Map<String, String> map = this.loadMethod();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            MethodKey key = new MethodKey(entry.getKey());
            resMap.put(key, SecurityConfig.createListFromCommaDelimitedString(entry.getValue()));
        }

        return resMap;
    }

}
