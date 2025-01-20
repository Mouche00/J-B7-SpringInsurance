package com.insurance.repositories.implementations;

import com.insurance.models.User;
import com.insurance.repositories.UserRepository;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryImpl extends GenericRepositoryImpl<User, UUID> implements UserRepository {
    protected UserRepositoryImpl() {
        super(User.class);
    }

    @Override
    @Transactional
    public Optional<User> findByEmail(String email) {
        try {
            return Optional.of(
                    entityManager.createQuery("select e from User e where e.email = :email", entityClass)
                            .setParameter("email", email)
                            .getSingleResult()
            );
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
