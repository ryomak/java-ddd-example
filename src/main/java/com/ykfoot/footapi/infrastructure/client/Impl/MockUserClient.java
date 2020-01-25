package com.ykfoot.footapi.infrastructure.client.Impl;

import com.ykfoot.footapi.domain.user.User;
import com.ykfoot.footapi.domain.user.value.Role;
import com.ykfoot.footapi.domain.user.value.UserID;
import com.ykfoot.footapi.infrastructure.client.UserClient;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Optional;

@Component
public class MockUserClient implements UserClient {

    private static HashMap<UserID,User> mockData = new HashMap<UserID,User>() {
        {
            put(UserID.of("user-1"), User.builder()
                    .name("yamawo")
                    .age(29)
                    .role(Role.USER)
                    .uid(UserID.of("user-1"))
                    .build());
            put(UserID.of("user-2"), User.builder()
                    .name("ryomak")
                    .age(23)
                    .role(Role.ADMIN)
                    .uid(UserID.of("user-2"))
                    .build());
        }
    };

    public Optional<User> get(UserID userID){
        return Optional.ofNullable(mockData.get(userID));
    }
}
