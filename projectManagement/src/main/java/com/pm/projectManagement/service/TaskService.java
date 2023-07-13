package com.pm.projectManagement.service;

import java.util.List;
import com.pm.projectManagement.entity.Task;
public interface TaskService {
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    Task createTask(Task task);
    Task updateTask(Long id, Task taskDetails);
    void deleteTask(Long id);
}

