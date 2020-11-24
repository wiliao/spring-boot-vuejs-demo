package com.example.boot.filter;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * HTML5 History Mode
 * https://router.vuejs.org/guide/essentials/history-mode.html#example-server-configurations
 * 
 * Using history mode for nicer URLs
 * https://github.com/jonashackt/spring-boot-vuejs#using-history-mode-for-nicer-urls
 * 
 * Spring MVC - Enable HTML5 history mode
 * https://gist.github.com/SylvainMarty/5b0427a0bed3a46cc60b691f7a5d1921
 * 
 * How to Define a Spring Boot Filter?
 * https://www.baeldung.com/spring-boot-add-filter
 */
@Component
public class HistoryModeFilter extends OncePerRequestFilter {

    // Update the regex as you needed
    private Pattern patt = Pattern.compile("^/([^\\.])*");
    // Main route
    private String endpoint = "/";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
    	String uri = request.getRequestURI();
    	//localhost:8098/app/api for rest controller
        if(!uri.contains("api") && this.patt.matcher(request.getRequestURI()).matches()) {
            RequestDispatcher rd = request.getRequestDispatcher(endpoint);
            rd.forward(request, response);
        } else {
            filterChain.doFilter(request, response);
        }
    }

}
