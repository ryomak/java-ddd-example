package com.ykfoot.footapi.infrastructure.client;

import com.ykfoot.footapi.domain.user.User;
import com.ykfoot.footapi.domain.user.value.UserID;

import java.util.Optional;

public interface UserClient {
    public Optional<User> get(UserID userID);
}
