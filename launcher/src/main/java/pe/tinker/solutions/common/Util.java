package pe.tinker.solutions.common;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import pe.tinker.solutions.db.model.Role;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public static List<GrantedAuthority> grantedAuthorities(Role role) {
        List<GrantedAuthority> grantedAuths = new ArrayList<>();
        grantedAuths.add(new SimpleGrantedAuthority(role.getRoleName()));
        return grantedAuths;
    }
}
