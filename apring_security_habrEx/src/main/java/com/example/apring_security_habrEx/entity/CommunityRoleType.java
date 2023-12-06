package com.example.apring_security_habrEx.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum CommunityRoleType implements Role{
    ADMIN, MODERATOR;

    private final Set<Role> children=new HashSet<>();

    static {
        ADMIN.children.add(MODERATOR);//по иерархии админ самая старшая роль, модератор младше
        MODERATOR.children.addAll(List.of(PostRoleType.EDITOR,PostRoleType.REPORTER));// а еще младше но на одном уровне редактор и модератор
    }

    @Override//Если переданная role равна this, возвращаем true.
    public boolean includes(Role role) {
        return this.equals(role)|| children.stream().anyMatch(r-> role.includes(role));
    }
}
