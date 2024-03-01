package com.zack.api.roles;

public enum UserRole {
    ADMIN("admin"),
    USER("user");

    public String getRole() {
        return role;
    }

    void setRole(String role) {
        this.role = role;
    }

    private String role;

    UserRole(String role) {
        this.role = role;
    }
}