package com.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author xtaod
 */
public class JAdminFilter extends IAdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        doAdminFilter(request, response, chain, "教务管理员");
    }
}
