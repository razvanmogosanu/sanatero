package com.example.sanateroapi.repositories;

import com.example.sanateroapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(nativeQuery = true, value = "select sanatero.login_user(:username, :password)")
    Boolean loginUser(@Param("username")String username, @Param("password")String password);

    @Query(nativeQuery = true, value = "call sanatero.get_all_doctors()")
    List<User> getAllDoctors();

    Optional<User> getByUsername(String username);

    @Query(nativeQuery = true, value = "select sanatero.get_the_user_with_biggest_expenses()")
    Integer getUserWithBiggestExpenses();

}
