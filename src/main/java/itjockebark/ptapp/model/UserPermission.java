package itjockebark.ptapp.model;

public enum UserPermission {
    PERMISSION_ALL("permission:all"),
    PERMISSION_PERSONAL_TRAINER("permission:personal_trainer"),
    PERMISSION_ADMIN("permission:admin");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
