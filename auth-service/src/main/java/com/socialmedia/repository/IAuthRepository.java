package com.socialmedia.repository;

import com.socialmedia.repository.entity.Auth;
import com.socialmedia.repository.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAuthRepository extends JpaRepository<Auth,Long> {
    Boolean existsByUsernameAndPassword(String username,String password);
    Optional<Auth> findOptionalByUsernameAndPassword(String username, String password);
    Optional<Auth> findOptionalByUsername(String username);
    List<Auth> findAllByRole(ERole role);
}
