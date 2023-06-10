package programmerzamannow.webMVC.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import programmerzamannow.webMVC.model.User;

@Component
public class SessionInterceptor implements HandlerInterceptor{
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");

        if(user == null){
            response.sendRedirect("/login");
            return false;
        }

        return true;
    }
}
