package org.sonyue.web.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @author nblookup 2016/10/9
 */
public class HelloServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init...");
        System.out.println(servletConfig.getInitParameter("user"));
        System.out.println(servletConfig.getInitParameter("password"));
        System.out.println(servletConfig.getServletName());
        System.out.println(servletConfig.getClass());
        Enumeration<String> names = servletConfig.getInitParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            System.out.println("name: " + name + ", value: " + servletConfig.getInitParameter(name));
        }

        System.out.println("------------华丽的分割线------------");

        //一个web应用中的所有servlet都共享同一个servletContext对象
        /**
         * ServletContext接口作用：
         * 1、获取web应用程序的初始化参数
         * 2、记录日志
         * 3、application域范围的属性
         * 4、访问资源文件
         * 5、获取虚拟路径所映射的本地路径
         * 6、web应用程序之间的访问
         * 7、其他
         *
         */

        //获取当前web应用的初始化参数，也就是用<context-param>配置的参数
        ServletContext servletContext = servletConfig.getServletContext();
        Enumeration<String> initContextNames = servletContext.getInitParameterNames();
        while (initContextNames.hasMoreElements()) {
            String name = initContextNames.nextElement();
            System.out.println("name: " + name + ", value: " + servletContext.getInitParameter(name));
        }
        System.out.println("contextPath: " + servletContext.getContextPath());
        System.out.println("------------华丽的分割线------------");

        //获取当前web应用的某一个文件在服务器上的绝对路径
        String realPath = servletContext.getRealPath("/test.properties"); //参数是相对于当前web应用部署根目录而言的
        System.out.println("test.properties' realPath: " + realPath);
        System.out.println("------------华丽的分割线------------");

        //获取当前web应用的contextPath，也就是当前web应用的根路径的相对路径，也就是$CATALINA_BASE/conf/Catalina/localhost下面配置的相对路径
        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);
        System.out.println("------------华丽的分割线------------");

        //获取当前web应用的某一个文件对应的输入流
        try {
            ClassLoader classLoader = this.getClass().getClassLoader();
            InputStream is = classLoader.getResourceAsStream("test.properties"); //参数是相对于类的跟路径，前面不加斜杠
            System.out.println("1. " + is);
            Properties properties = new Properties();
            properties.load(is);
            System.out.println("property: " + properties.get("test"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream is2 = servletContext.getResourceAsStream("/WEB-INF/classes/test.properties"); //参数为相对于当前web应用的路径
            System.out.println("2. " + is2);
            Properties properties = new Properties();
            properties.load(is2);
            System.out.println("property: " + properties.get("test"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("------------华丽的分割线------------");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig...");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service...");
    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo...");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy...");
    }

    public HelloServlet() {
        System.out.println("HelloServlet constructor...");
    }
}
