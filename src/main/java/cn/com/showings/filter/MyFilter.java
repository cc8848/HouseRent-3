package cn.com.showings.filter;

import cn.com.showings.pojo.SysUsers;
import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/12/23
 * 类说明:
 * 更新记录：
 */
public class MyFilter implements Filter {

    private final static String USER_ID = "NotLogin";

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        SysUsers sysUsers = (SysUsers) request.getSession().getAttribute("user");
        if (null != sysUsers) {
            //MDC是用于当然不仅可用于，logback日志当中，存放特定数据的。
            MDC.put("userID", sysUsers.getUserId().toString());
        } else {
            MDC.put("userID", USER_ID);
        }
        filterChain.doFilter(request, response);
    }

    public void destroy() {

    }
}
