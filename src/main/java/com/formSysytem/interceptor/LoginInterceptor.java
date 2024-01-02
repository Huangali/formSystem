package com.formSysytem.interceptor;



import com.formSysytem.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;



public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        if (requestURI.startsWith(contextPath+"/statics/")){
            return true;
        }
        User currentUser = (User)request.getSession().getAttribute("user");
        if(currentUser == null) {
            if (requestURI.startsWith(contextPath+ "/login.html") || requestURI.startsWith(contextPath+"/admin/login") || requestURI.startsWith(contextPath+"/admin/save")){
                return true;
            }
            // 用户未登录，重定向到登录页面
            response.sendRedirect(request.getContextPath() + "/login.html");
            return false; //不再调用handler，返回
        }else{
           if (requestURI.startsWith(contextPath+ "/login.html")) {
               response.sendRedirect(request.getContextPath() + "/");
           }
            return true;  //继续调用handler
        }
    }
}
