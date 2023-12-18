package com.mclearn.admin.repository;

import com.mclearn.admin.entity.User;
import com.mclearn.admin.entity.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<List<User>> findAllByRole(Role role);
}
