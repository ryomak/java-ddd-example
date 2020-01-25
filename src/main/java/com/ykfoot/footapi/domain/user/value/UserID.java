package com.ykfoot.footapi.domain.user.value;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.Optional;

@Value
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class UserID {

    private final String value;

    public static UserID of(String value) {
        return Optional.ofNullable(value).map(UserID::new)
                .orElseThrow(()-> new IllegalArgumentException("must not be null"));
    }
}
