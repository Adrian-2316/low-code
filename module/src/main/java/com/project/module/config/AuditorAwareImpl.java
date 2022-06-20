package com.project.module.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("anonymousUser");
    }


    //TODO Descomentar cuando se implemente la seguridad
    /*@Override
    public Optional<String> getCurrentAuditor() {
        if (!isAuthenticated()) return Optional.of("anonymousUser");
        Authentication authenticated = getAuthenticated();
        CustomUserDetails customUserDetails = (CustomUserDetails) authenticated;
        return Optional.of(customUserDetails.getEmail());
    }

    public boolean isAuthenticated() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        if (authentication == null) return false;
        if (!authentication.isAuthenticated()) return false;
        return !authentication.getPrincipal().equals("anonymousUser");
    }

    public Authentication getAuthenticated() {
        SecurityContext context = SecurityContextHolder.getContext();
        return context.getAuthentication();
    }*/
}

