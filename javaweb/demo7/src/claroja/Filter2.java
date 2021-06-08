package claroja;

import javax.servlet.*;
import java.io.IOException;

public class Filter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain
            filterChain) throws IOException, ServletException {
        System.out.println("chain.dofilter2之前代码执行");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("chain.dofilter2之后代码执行");
    }

    @Override
    public void destroy() {

    }
}
