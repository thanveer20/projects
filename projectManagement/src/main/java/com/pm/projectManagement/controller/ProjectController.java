package com.pm.projectManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pm.projectManagement.entity.Project;
import com.pm.projectManagement.repo.ProjectRepo;

@RestController
public class ProjectController {
	
	@Autowired
	ProjectRepo projectRepo;
	
	@PostMapping("/api/projects")
	public ResponseEntity<Project> saveProject(@RequestBody Project project) {
		return new ResponseEntity<> (projectRepo.save(project),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/api/projects")
	public ResponseEntity<List<Project>> getProjects() {
		return new ResponseEntity<>(projectRepo.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/api/projects/{id}")
	public ResponseEntity<Project> getProject(@PathVariable long id) {
		Optional<Project> project = projectRepo.findById(id);
		if(project.isPresent()) {
			return new ResponseEntity<>(project.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/api/projects/{id}")
	public ResponseEntity<Project> updateProject(@PathVariable long id,@RequestBody Project proj) {
		Optional<Project> project = projectRepo.findById(id);
		if(project.isPresent()) {
			project.get().setProjectName(proj.getProjectName());
			project.get().setProjectDescription(proj.getProjectDescription());
			project.get().setProjectStartDate(proj.getProjectStartDate());
			project.get().setProjectEndDate(proj.getProjectEndDate());
			return new ResponseEntity<>(projectRepo.save(project.get()),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/api/projects/{id}")
	public ResponseEntity<Void> deleteProject(@PathVariable long id) {
		Optional<Project> project = projectRepo.findById(id);
		if(project.isPresent()) {
			projectRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
