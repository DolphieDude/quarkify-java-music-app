package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.Role;

import java.util.Comparator;
import java.util.List;

@ApplicationScoped
public class RoleService {

    public List<Role> sortRoles(List<Role> roles) {
        return roles.stream().sorted(Comparator.comparing(Role::getName)).toList();
    }
}
