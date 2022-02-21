package io.gettarrays.userservice.service;

import io.gettarrays.userservice.domain.Role;
import io.gettarrays.userservice.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    // Ajout d'un role à un user
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User>getUsers();
}
