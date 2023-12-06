package com.example.apring_security_habrEx.entity;

import java.util.HashSet;
import java.util.Set;

//енам с ролями, оторые могут редачить
public enum PostRoleType implements Role{
    VIEWER, EDITOR, REPORTER;

    private final Set<Role> children=new HashSet<>();

    static {//по иерархии роль репортер и редактор стоят на одном уровне, а зритель самая младшая
        REPORTER.children.add(VIEWER);
        EDITOR.children.add(VIEWER);
    }

    @Override//проверяет, равна ли та роль, что мы передали в методе, текущей, или же содержится она в children nodes
    public boolean includes(Role role) {
        return this.equals(role)||children.stream().anyMatch(r->r.includes(role));
    }
}
