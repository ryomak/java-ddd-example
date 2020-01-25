package com.ykfoot.footapi.presentation.controller.v1.resource.constant;

import com.fasterxml.jackson.annotation.JsonValue;
import com.ykfoot.footapi.domain.user.value.Role;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum  UserRole {
    NONE("unexpected"),
    ADMIN("admin"),
    USER("user");

    private final String jsonValue;

    @JsonValue
    public String getJsonValue(){return jsonValue;}

    public static UserRole of(Role role) {
        switch (role) {
            case ADMIN:
                return UserRole.ADMIN;
            case USER:
                return UserRole.USER;
            default:
                return UserRole.NONE;
        }
    }

}
