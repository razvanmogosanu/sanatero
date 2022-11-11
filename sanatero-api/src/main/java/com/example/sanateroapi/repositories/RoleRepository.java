package com.example.sanateroapi.repositories;

import com.example.sanateroapi.models.Role;
import com.example.sanateroapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Integer> {
    Role getByName(String name);
}
