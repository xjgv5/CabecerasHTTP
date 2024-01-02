package com.xjgv.apiservlet.webapp.headers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

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
            out.println("         </ul>");
            out.println("     </body>");
            out.println("</html>");
        }
    }
}
