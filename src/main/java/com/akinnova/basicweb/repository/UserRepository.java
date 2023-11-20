package com.akinnova.basicweb.repository;

import com.akinnova.basicweb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByAge(int age);
    List<User> findByNameAndPassword(String name, String password);
}
