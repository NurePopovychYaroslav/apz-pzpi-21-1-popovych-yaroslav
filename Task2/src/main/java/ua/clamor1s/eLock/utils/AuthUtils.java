package ua.clamor1s.eLock.utils;

import lombok.experimental.UtilityClass;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;

import java.util.Optional;

@UtilityClass
public class AuthUtils {
    public Optional<DefaultOidcUser> getAuthUser() {
        var authenticationToken = SecurityContextHolder.getContext().getAuthentication();
        if (authenticationToken.getPrincipal() instanceof String) {
            return Optional.empty();
        }
        return Optional.of((DefaultOidcUser) authenticationToken.getPrincipal());
    }
}
