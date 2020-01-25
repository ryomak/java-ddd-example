package com.ykfoot.footapi.domain.user;

import com.ykfoot.footapi.domain.user.value.UserID;

public interface UserRepository {
    public User FindByUid(UserID userID);
}
