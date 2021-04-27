package pl.przychodniagardno.przychodniab.security;

public enum Permission {

    NEWS_WRITE("news:write"),
    NEWS_UPDATE("news:update");

    private final String permissions;

    Permission(String permissions) {
        this.permissions = permissions;
    }

    public String getPermissions() {
        return permissions;
    }
}
