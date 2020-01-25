package com.ykfoot.footapi.presentation.controller.v1;

import com.ykfoot.footapi.application.UserService;
import com.ykfoot.footapi.application.UserService.Output;
import com.ykfoot.footapi.domain.user.value.UserID;
import com.ykfoot.footapi.presentation.controller.v1.resource.constant.UserRole;
import com.ykfoot.footapi.presentation.controller.v1.resource.response.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1")
@Slf4j
public class UserController {

    private final UserService service;

    @GetMapping("/user/{id}")
    public UserResponse get(
            @PathVariable("id") String id
    ) {
        log.info("get start");
        Output output = service.get(UserService.Input.builder().userID(UserID.of(id)).build());
        log.info("get end");

        return UserResponse.builder()
                .name(output.getUser().getName())
                .uid(output.getUser().getUid().getValue())
                .age(output.getUser().getAge())
                .role(UserRole.of(output.getUser().getRole())).build();
    }

}
