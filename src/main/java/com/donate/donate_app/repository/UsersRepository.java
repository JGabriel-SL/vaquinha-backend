package com.donate.donate_app.repository;

import com.donate.donate_app.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
