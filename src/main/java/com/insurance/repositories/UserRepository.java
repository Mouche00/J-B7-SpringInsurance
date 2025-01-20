package com.insurance.repositories;

import com.insurance.models.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends GenericRepoistory<User, UUID> {
    Optional<User> findByEmail(String email);
}
