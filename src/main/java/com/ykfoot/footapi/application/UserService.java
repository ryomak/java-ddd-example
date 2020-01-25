package com.ykfoot.footapi.application;

import com.ykfoot.footapi.domain.user.User;
import com.ykfoot.footapi.domain.user.value.UserID;
import lombok.Builder;
import lombok.Getter;

public interface UserService {

    Output get(Input input);

    @Builder
    @Getter
    class Input {
        UserID userID;
    }

    @Builder
    @Getter
    class Output {
        User user;
    }
}
