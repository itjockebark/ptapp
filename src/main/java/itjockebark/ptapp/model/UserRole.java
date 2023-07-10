package itjockebark.ptapp.model;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static itjockebark.ptapp.model.UserPermission.*;

public enum UserRole {
    USER(Sets.newHashSet(PERMISSION_ALL)),
    PERSONAL_TRAINER(Sets.newHashSet(PERMISSION_ALL, PERMISSION_PERSONAL_TRAINER)),
    ADMIN(Sets.newHashSet(PERMISSION_ALL, PERMISSION_PERSONAL_TRAINER, PERMISSION_ADMIN));

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> grantedPermissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        grantedPermissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return grantedPermissions;
    }
}
