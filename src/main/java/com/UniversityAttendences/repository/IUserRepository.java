package com.UniversityAttendences.repository;

import com.UniversityAttendences.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {

    List<User> findAll();

    Optional<User> findById(String id);

    void deleteById(String s);
}
