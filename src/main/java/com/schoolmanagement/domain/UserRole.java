package com.schoolmanagement.domain;

public enum UserRole {
    ROLE_ADMIN("admin"),
    ROLE_TEACHER("teacher"),
    ROLE_STUDENT("student"),
    ROLE_DEAN("dean");

    private final String name;

    UserRole(String name) {  //constructor --> degisken icindeki aciklamlari degistirme imkani sunar
        this.name = name;
    }

    public String getName() {
        return name;
    }
}