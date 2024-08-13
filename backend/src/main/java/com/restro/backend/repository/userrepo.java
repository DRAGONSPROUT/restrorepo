package com.restro.backend.repository;

import com.restro.backend.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userrepo extends JpaRepository<user, Long> {


    user findByUsername(String username);
}
