package com.example.todo.service;

import com.example.todo.model.Task;
import com.example.todo.model.Status;
import com.example.todo.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskService {

    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
        logger.info("TaskService initialized");
    }

    public List<Task> getAllTasks() {
        logger.debug("Fetching all tasks");
        return taskRepository.findAll();
    }

    public List<Task> getTasksByStatus(Status status) {
        logger.debug("Fetching tasks with status: {}", status);
        return taskRepository.findByStatus(status);
    }

    public Task getTaskById(Long id) {
        logger.debug("Fetching task with id: {}", id);
        return taskRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Task not found with id: {}", id);
                    return new RuntimeException("Task not found with id: " + id);
                });
    }

    public Task saveTask(Task task) {
        if (task.getStatus() == null) {
            logger.debug("Setting default status for new task");
            task.setStatus(Status.IN_PROGRESS);
        }
        logger.info("Saving task: {}", task.getDescription());
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        logger.info("Deleting task with id: {}", id);
        taskRepository.deleteById(id);
    }

    public Task updateTaskStatus(Long id, Status status) {
        logger.debug("Updating task status. ID: {}, New Status: {}", id, status);
        Task task = getTaskById(id);
        task.setStatus(status);
        return taskRepository.save(task);
    }

    public List<Task> searchTasks(String keyword) {
        logger.debug("Searching tasks with keyword: {}", keyword);
        return taskRepository.findByDescriptionContainingIgnoreCase(keyword);
    }
}