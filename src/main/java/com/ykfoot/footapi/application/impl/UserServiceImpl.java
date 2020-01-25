package com.ykfoot.footapi.application.impl;

import com.ykfoot.footapi.application.UserService;
import com.ykfoot.footapi.domain.user.User;
import com.ykfoot.footapi.domain.user.UserRepository;
import com.ykfoot.footapi.domain.user.value.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public Output get(Input input) {
        User user = userRepository.FindByUid(input.getUserID());
        if (Role.NONE.equals(user.getRole())){
            user.setRole(Role.ADMIN);
        }
        return Output.builder().user(user).build();
    }
}
