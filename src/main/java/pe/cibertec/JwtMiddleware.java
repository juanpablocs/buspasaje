package pe.cibertec;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import java.io.IOException;

@Component
public class JwtMiddleware extends GenericFilterBean {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String path = httpRequest.getRequestURI();

        // Permitir acceso sin autenticación a /api/auth/**
        if (path.startsWith("/api/auth")) {
            chain.doFilter(request, response);
            return;
        }

        // Obtener el token del header Authorization
        String authHeader = httpRequest.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.getWriter().write("{\"error\":\"Acceso no autorizado: Falta el token\"}");
            response.setContentType("application/json");
            response.getWriter().flush();
            return;
        }

        String token = authHeader.substring(7); // Quitar "Bearer "

        System.out.println("Token: " + token);
        try {
            String username = jwtUtil.extractUsername(token);
            System.out.println("Username: " + username);
            if (username == null || jwtUtil.isTokenExpired(token)) {
                response.getWriter().write("{\"error\":\"Acceso no autorizado: Token inválido o expirado\"}");
                response.setContentType("application/json");
                response.getWriter().flush();
                return;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            response.getWriter().write("{\"error\":\"Acceso no autorizado: Token inválido o expirado\"}");
            response.setContentType("application/json");
            response.getWriter().flush();
            return;
        }

        // Continuar con la petición si el token es válido
        chain.doFilter(request, response);
    }
}

