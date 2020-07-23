package cn.yn.bootdemo.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@Slf4j
@WebFilter(urlPatterns = "/*",filterName = "myFilter")
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("这是一个Web Filter");
        log.info("------------------"+((HttpServletRequest)request).getRequestURL());
        chain.doFilter(request,response);
    }
}
