package com.filter;

import javax.servlet.*;
import java.io.IOException;

public class SAdminFilter extends IAdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        doAdminFilter(request, response, chain, "系统管理员");
    }
}
