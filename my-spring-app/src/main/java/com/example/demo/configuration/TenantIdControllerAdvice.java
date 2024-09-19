package com.example.demo.configuration;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// import java.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class TenantIdControllerAdvice {

    Logger logger = LoggerFactory.getLogger(TenantIdControllerAdvice.class);

    // @ModelAttribute
    // public void addAttributes(HttpServletRequest request, @PathVariable("tenantId") String tenantId) {
    //     // Store tenantId in request attributes so it can be accessed by any controller
    //    // request.setAttribute("tenantId", tenantId);
    //     logger.info("tenantId", tenantId);
    //     TenantContext.setCurrentTenant(tenantId);
    // }
}

