import javax.servlet.*;
import java.io.IOException;

public class LogFilter implements Filter {
    private int hinCount = 0;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        // 获取初始化参数
        String site = filterConfig.getInitParameter("Site");
        // 输出初始化参数
        System.out.println("网站名称: " + site);
        hinCount = 0;

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        hinCount++;
        // 输出站点名称
        System.out.println("访问统计 = " + hinCount);

        // 把请求传回过滤链
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
