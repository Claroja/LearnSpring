package claroja;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HelloServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext 对象创建"+servletContextEvent.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext 对象销毁");

    }
}
