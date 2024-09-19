package com.example.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final TenantInterceptor tenantInterceptor;
    private final TenantIdArgumentResolver tenantIdArgumentResolver;

    public WebConfig(TenantInterceptor tenantInterceptor, TenantIdArgumentResolver tenantIdArgumentResolver) {
        this.tenantInterceptor = tenantInterceptor;
        this.tenantIdArgumentResolver = tenantIdArgumentResolver;
    }

    @Override
    public void addInterceptors(@SuppressWarnings("null") InterceptorRegistry registry) {
        registry.addInterceptor(tenantInterceptor).addPathPatterns("/{tenantId}/api/**");
        // Add the tenant interceptor to intercept all incoming requests (or specific paths)
        // registry.addInterceptor(tenantInterceptor).addPathPatterns("/api/**");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(tenantIdArgumentResolver);
    }
}