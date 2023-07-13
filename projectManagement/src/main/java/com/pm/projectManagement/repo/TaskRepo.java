package com.pm.projectManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pm.projectManagement.entity.Task;

public interface TaskRepo extends JpaRepository<Task, Long> {
	
}