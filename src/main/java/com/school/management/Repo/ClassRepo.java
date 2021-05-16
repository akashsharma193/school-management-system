package com.school.management.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.school.management.entity.ClassEntity;

@Repository
public interface ClassRepo extends JpaSpecificationExecutor<ClassEntity>, JpaRepository<ClassEntity, Integer>{

}
