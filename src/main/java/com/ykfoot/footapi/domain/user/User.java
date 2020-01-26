package com.ykfoot.footapi.domain.user;

import com.ykfoot.footapi.domain.user.value.Role;
import com.ykfoot.footapi.domain.user.value.UserID;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
    private UserID uid;
    private String name;
    private int age;
    private Role role;

    public boolean isAdmin(){
        return Role.ADMIN.equals(role);
    }
}
