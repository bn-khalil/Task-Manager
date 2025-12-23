package com.bn.tasks.Repositories;

import com.bn.tasks.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    @Query("""
            select u from User u where userName = :userName or email = :email
            """)
    Optional<User> findByUserNameOrEmail(String userName, String email);
}
