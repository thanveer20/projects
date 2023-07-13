package com.pm.projectManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.pm.projectManagement.entity.Project;

public interface ProjectRepo extends JpaRepository<Project, Long> {

}
