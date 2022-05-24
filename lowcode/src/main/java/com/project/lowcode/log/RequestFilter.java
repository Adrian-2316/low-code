package com.project.lowcode.log;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.*;

@Component
@AllArgsConstructor
public class RequestFilter implements Filter {

    private RequestLogger requestLogger;

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        requestLogger.log(request, response, chain);
    }

    @Override
    public void destroy() {
    }
}
