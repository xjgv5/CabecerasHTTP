package com.xjgv.apiservlet.webapp.headers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/cabeceras-request")
public class CabecerasHttpRequest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String metodoHttp = req.getMethod();
        String requestUri = req.getRequestURI();
        String requestURL = req.getRequestURL().toString();
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String ipCliente = req.getRemoteAddr();
        String ip = req.getLocalAddr();
        int port = req.getLocalPort();
        String schema = req.getScheme();
        String host = req.getHeader("host");
        String url = schema + "://" + host + contextPath + servletPath;
        String url2 = schema+"://"+ ip + ":" + port + contextPath + servletPath;

        try (PrintWriter out = resp.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("     <head>");
            out.println("         <meta charset=\" UTF-8\">");
            out.println("         <title>Cabeceras HTTP Request</title>");
            out.println("     </head>");
            out.println("     <body>");
            out.println("         <h1>Cabeceras HTTP Request</h1>");
            out.println("         <ul>");
            out.println("               <li>Método http: " + metodoHttp + "</li>");
            out.println("               <li>Request URI: " + requestUri + "</li>");
            out.println("               <li>Request URL: " + requestURL + "</li>");
            out.println("               <li>Context Path: " + contextPath + "</li>");
            out.println("               <li>Servleth Path: " + servletPath + "</li>");
            out.println("               <li>IP Local: " + ip + "</li>");
            out.println("               <li>IP Cliente: " + ipCliente + "</li>");
            out.println("               <li>Puerto Local: " + port + "</li>");
            out.println("               <li>Scheme: " + schema + "</li>");
            out.println("               <li>Host: " + host + "</li>");
            out.println("               <li>URL: " + url + "</li>");
            out.println("               <li>URL2: " + url2 + "</li>");

            Enumeration<String> headerNames = req.getHeaderNames();
            while (headerNames.hasMoreElements()){
                String cabecera = headerNames.nextElement();
                out.println("<li>" + cabecera + ": " + req.getHeader(cabecera) + "</li>");
            }

            out.println("         </ul>");
            out.println("     </body>");
            out.println("</html>");
        }
    }
}
