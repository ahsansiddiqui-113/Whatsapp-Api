package com.whatsappapi.api.Repository;

import com.whatsappapi.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByEmail(String email);

    List<User> findByUsernameContaining(String keyword);

    List<User> findByRole(Role role);

    List<User> findByActive(boolean active);

    List<User> findByCreatedAtGreaterThan(long timestamp);

    List<User> findByCreatedAtLessThan(long timestamp);

    List<User> findByCreatedAtBetween(long startTimestamp, long endTimestamp);

    long countByRole(Role role);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}

