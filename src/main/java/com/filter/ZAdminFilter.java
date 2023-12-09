package com.filter;

import javax.servlet.*;
import java.io.IOException;

public class ZAdminFilter extends IAdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        doAdminFilter(request, response, chain, "招生管理员");
    }
}
