package pe.tinker.solutions.security.auth.ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import pe.tinker.solutions.common.Util;
import pe.tinker.solutions.db.model.Role;
import pe.tinker.solutions.db.model.User;
import pe.tinker.solutions.rest.service.IDatabaseUserService;
import pe.tinker.solutions.security.model.UserContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hans_h'bravo on 21/12/2017.
 */
@Component
public class AjaxAuthenticationProvider implements AuthenticationProvider {
    private final BCryptPasswordEncoder encoder;
    private final IDatabaseUserService userService;

    @Autowired
    public AjaxAuthenticationProvider(final IDatabaseUserService userService, final BCryptPasswordEncoder encoder) {
        this.userService = userService;
        this.encoder = encoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Assert.notNull(authentication, "Datos de autenticaci\u00f3n no proveidos");


        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        User user = userService.getByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User no encontrado: " + username));

        if (!user.getStatus()) {
            throw new BadCredentialsException("User inactivo.");
        }

        if (!encoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("User o contrase\u00f1a no v\u00e1lidos.");
        }


        if (user.getRole() == null) throw new InsufficientAuthenticationException("User no tiene roles asignados");

        List<GrantedAuthority> authorities = Util.grantedAuthorities(user.getRole());

        UserContext userContext = UserContext.create(user.getId(), authorities);

        return new UsernamePasswordAuthenticationToken(userContext, null, userContext.getAuthorities());
    }

  

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}