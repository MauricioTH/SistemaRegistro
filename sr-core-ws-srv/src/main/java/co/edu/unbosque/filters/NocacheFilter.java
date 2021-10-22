/*
 * NocacheFilter
 *  
 * GSI - Integración
 * Creado el: 07/10/2015
 *
 * Copyright (c) A Toda Hora S.A. Todos los derechos reservados
 * 
 * Este software es confidencial y es propietario de ATH, queda prohibido
 * su uso, reproducción y copia de manera parcial o permanente salvo autorización
 * expresa de A Toda Hora S.A o de quién represente sus derechos.
 */
package co.edu.unbosque.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import co.edu.unbosque.constants.FilterConstants;

/**
 * Clase que evita el uso del caché web para las peticiones que realicen 
 * al Core
 * 
 * @author Mauricio Tascon
 * @version 1.0 28/09/2017
 * @since 1.0
 */
public class NocacheFilter implements Filter {
    
    public void doFilter(ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        httpResponse.setHeader(FilterConstants.HEADER_CACHE_CONTROL, FilterConstants.HEADER_VALUE);
        httpResponse.setDateHeader(FilterConstants.HEADER_NAME_EXPIRATION, FilterConstants.HEADER_VALUE_EXPIRATION);
        
        chain.doFilter(request, response);
    }
    
    
    public void destroy() {}
    public void init(FilterConfig fConfig) throws ServletException {}
}