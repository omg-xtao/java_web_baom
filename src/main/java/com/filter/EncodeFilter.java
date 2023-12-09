package com.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author xtaod
 */
public class EncodeFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = ((HttpServletRequest) request);
        if (req.getRequestURI().contains("code.jsp")) {
            chain.doFilter(request, response);
            return;
        }
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        chain.doFilter(request, response);
    }
}
