package com.example.apring_security_habrEx.entity;

import java.util.Set;

public interface Role {
    boolean includes(Role role);

    static Set<Role> roots(){
        return Set.of(CommunityRoleType.ADMIN);
    }
}
