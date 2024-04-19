package com.tealmarket.artem.backendService.repository;

import com.tealmarket.artem.backendService.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
