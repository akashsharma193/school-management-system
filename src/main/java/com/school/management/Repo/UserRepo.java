package com.school.management.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.school.management.entity.User;

@Repository
public interface UserRepo extends JpaSpecificationExecutor<User>, JpaRepository<User, Integer> {

	User findByEmail(String email);

}
