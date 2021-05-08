package com.school.management.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.school.management.entity.UserInfo;

@Repository
public interface UserRepo extends JpaSpecificationExecutor<UserInfo>, JpaRepository<UserInfo, Integer> {

	UserInfo findByEmail(String email);

	UserInfo getByEmail(String username);


}
