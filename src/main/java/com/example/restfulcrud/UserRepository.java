package com.example.restfulcrud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
<<<<<<< HEAD
=======

>>>>>>> 462dda54bb297b230009672a6bb5ea913f78deca
}
