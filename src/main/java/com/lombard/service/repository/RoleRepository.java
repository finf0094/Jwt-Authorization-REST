package com.lombard.service.repository;

import com.lombard.service.entities.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Optional<Role> findByName(String name);

    Role getRoleByName(String name);
}
