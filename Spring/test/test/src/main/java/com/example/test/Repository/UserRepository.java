package com.example.test.Repository;

import com.example.test.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {

    Users findFirstByEmailIgnoreCaseAndPassword(String email, String password);
}
