/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.acm.Security.jwt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 *
 * @author acm1ux3r0
 */

        //<<<<<<<   CLASE PARA CHECAR SI HAY UN TOKEN VÁLIDO.   >>>>>>>>>>

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {

    // PRIMERO SE REALIZAN LAS CLASES Y DESPUÉS SE IMPLEMENTARÁN LOS MÉTODOS ABSTRACTOS
    private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);

    //Implementación de los métodos abstractos
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        logger.error("Falló el método commence");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
