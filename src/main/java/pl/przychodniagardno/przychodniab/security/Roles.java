package pl.przychodniagardno.przychodniab.security;

import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Set;

import static pl.przychodniagardno.przychodniab.security.Permission.*;


public enum Roles {

    ADMIN(new HashSet<>(Sets.newHashSet(NEWS_WRITE,NEWS_UPDATE))),
    MODERATOR(Sets.newHashSet(NEWS_WRITE));

    private final Set<Permission> permissions;

    Roles(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }
}
