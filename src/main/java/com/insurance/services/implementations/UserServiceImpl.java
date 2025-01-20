package com.insurance.services.implementations;

import com.insurance.models.User;
import com.insurance.repositories.GenericRepoistory;
import com.insurance.repositories.UserRepository;
import com.insurance.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, String> implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(GenericRepoistory<User, UUID> genericRepoistory, UserRepository userRepository) {
        super(genericRepoistory);
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
