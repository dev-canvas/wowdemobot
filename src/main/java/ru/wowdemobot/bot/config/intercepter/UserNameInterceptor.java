package ru.wowdemobot.bot.config.intercepter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class UserNameInterceptor implements HandlerInterceptor {
    public static final ThreadLocal<String> currentUser = new ThreadLocal<>();

    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String name = request.getHeader("X-user-name");
        currentUser.set(name);
        return true;
    }

    public void afterCompletion (HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        currentUser.remove();
    }
}
