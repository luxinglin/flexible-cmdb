package cn.pioneer.dcim.cmdb.common.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author luxinglin
 * @since 2018-01-10
 */
public class PrePatchFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

}
