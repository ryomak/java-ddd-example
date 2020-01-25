package com.ykfoot.footapi.infrastructure.repository;

import com.ykfoot.footapi.domain.user.User;
import com.ykfoot.footapi.domain.user.UserRepository;
import com.ykfoot.footapi.domain.user.value.UserID;
import com.ykfoot.footapi.infrastructure.client.UserClient;
import com.ykfoot.footapi.infrastructure.repository.exception.NoneException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserClient userClient;

    @Override
    public User FindByUid(UserID userID) {
        return userClient.get(userID).orElseThrow(()->new NoneException("cannot find user by userid"));
    }
}
