package claroja;

import javax.servlet.*;
import java.io.IOException;

public class Filter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain
            filterChain) throws IOException, ServletException {
        System.out.println("chain.dofilter1之前代码执行");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("chain.dofilter1之后代码执行");
    }

    @Override
    public void destroy() {

    }
}
