package com.example.demo.configuration;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

public class SchemaBasedCurrentTenantIdentifierResolver implements CurrentTenantIdentifierResolver {

    private static final String DEFAULT_TENANT = "public"; // Default schema

    @Override
    public String resolveCurrentTenantIdentifier() {
        // Return the tenant identifier (schema name)
        String tenantId = TenantContext.getCurrentTenant();  // You need to implement TenantContext
        return (tenantId != null) ? tenantId : DEFAULT_TENANT;
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}