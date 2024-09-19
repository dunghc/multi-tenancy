package com.example.demo.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Map;
 

@Component
public class TenantInterceptor implements HandlerInterceptor {


    Logger logger = LoggerFactory.getLogger(TenantInterceptor.class);
    // @SuppressWarnings("null")
    // @Override
    // public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    //     // Extract the tenant identifier from the request header
    //     String tenantId = request.getHeader("X-Tenant-ID");

    //     // Set the tenant identifier in the TenantContext
    //     if (tenantId != null && !tenantId.isEmpty()) {
    //         TenantContext.setCurrentTenant(tenantId);
    //     } else {
    //         // Fallback to default tenant (optional)
    //         TenantContext.setCurrentTenant("default_tenant"); // Adjust according to your logic
    //     }

    //     // String requestURI = request.getRequestURI();

    //     // Assuming the URL pattern is /{tenantId}/mydata or similar
    //     // String[] parts = requestURI.split("/");
    //     // if (parts.length > 1) {
    //     //     tenantId = parts[1];  // Extract tenantId from the first part of the path
    //     //     // Store tenantId in a request attribute or any other context for later use
    //     //     TenantContext.setCurrentTenant(tenantId);
    //     //     System.out.println("Extracted Tenant ID: " + tenantId);
    //     // }
    //     return true;  // Continue processing the request
    // }

    @SuppressWarnings("null")
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // Clear the tenant context after the request is completed
        TenantContext.clear();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String, String> pathVariables = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        
        String tenantId = pathVariables.get("tenantId");
        logger.info("tenant id {}",tenantId);
        TenantContext.setCurrentTenant(tenantId);
        request.setAttribute("globalTenantId", tenantId);
        return true;
    }
}
