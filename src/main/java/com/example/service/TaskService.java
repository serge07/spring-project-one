package com.example.service;


import com.example.model.Task;
import com.example.repository.TaskRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public List<Task> findByTitle(String title) {
        return taskRepository.findByTitle(title);

    }


    public List<Task> findCompleted() {
        return taskRepository.findBCompleted(true);

    }

    public List<Task> findNotCompleted() {
        return taskRepository.findBCompleted(false);

    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();

    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow  (()-> new RuntimeException("Task not found with id:" +id));
    }
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task updateTaskStatus(Long id, boolean completed) {
        Task task = getTaskById(id);
        task.setCompleted(completed);
        return taskRepository.save(task);


    }
    public List<Task> searchTasks(String keyword) {
        return taskRepository.findByTitleContainingIgnoreCase(keyword);
    }


}
