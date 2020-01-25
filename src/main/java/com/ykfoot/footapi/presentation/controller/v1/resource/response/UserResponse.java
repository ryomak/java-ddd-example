package com.ykfoot.footapi.presentation.controller.v1.resource.response;

import com.ykfoot.footapi.presentation.controller.v1.resource.constant.UserRole;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private String uid;
    private String name;
    private int age;
    private UserRole role;
}
