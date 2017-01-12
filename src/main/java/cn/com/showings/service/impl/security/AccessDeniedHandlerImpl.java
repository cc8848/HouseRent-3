package cn.com.showings.service.impl.security;

import com.alibaba.fastjson.JSON;
import cn.com.showings.pojo.JsonResult;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.util.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/11/22
 * 类说明:
 * 更新记录：
 */
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

    private String errorPage;

    public AccessDeniedHandlerImpl() {
    }


    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        if (isAjaxRequest(request)) {
            response.setContentType("application/json");
            response.setHeader("contentType", "text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            JsonResult jsonResult = JsonResult.error("对不起，您无权进行此操作！");
            String jsonObject = JSON.toJSONString(jsonResult);
            PrintWriter out = response.getWriter();
            out.print(jsonObject);
            out.flush();
            out.close();
        } else {
            if (!response.isCommitted()) {
                if (this.errorPage != null) {
                    request.setAttribute("SPRING_SECURITY_403_EXCEPTION", accessDeniedException);
                    response.setStatus(403);
                    request.setAttribute("message", accessDeniedException.getMessage());
                    RequestDispatcher dispatcher = request.getRequestDispatcher(this.errorPage);
                    dispatcher.forward(request, response);
                } else {
                    response.sendError(403, accessDeniedException.getMessage());
                }
            }
        }
    }

    private boolean isAjaxRequest(HttpServletRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With")) || !StringUtils.isEmpty(request.getParameter("jsonp"));
    }

    public void setErrorPage(String errorPage) {
        if (errorPage != null && !errorPage.startsWith("/")) {
            throw new IllegalArgumentException("errorPage must begin with \'/\'");
        } else {
            this.errorPage = errorPage;
        }
    }
}
