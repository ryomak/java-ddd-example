package com.ykfoot.footapi.domain.user.value;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum  Role {
    ADMIN,
    USER,
    NONE;
}
