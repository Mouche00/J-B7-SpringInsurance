package com.insurance.services;

import com.insurance.models.User;

import java.util.Optional;

public interface UserService extends GenericService<User, String> {
    Optional<User> findByEmail(String email);
}
