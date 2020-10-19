package com.example.blog.repo;

import com.example.blog.models.ERole;
import com.example.blog.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.Set;

public interface RoleRepository extends MongoRepository<Role, String> {
    Set<Role> findByRole(ERole name);
}
