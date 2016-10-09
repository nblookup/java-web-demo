package org.sonyue.web.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author nblookup 2016/10/9
 */
public class HelloServlet2 implements Servlet {

    private String single;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.single = "单实例全局变量";
        System.out.println("init2...");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig2...");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        this.single += "x";
        System.out.println("service2..." + this.single);
    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo2...");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy2...");
    }

    public HelloServlet2() {
        System.out.println("HelloServlet2 constructor...");
    }

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single;
    }
}
