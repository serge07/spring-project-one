package com.example.todo.repository;

import com.example.todo.model.Task;
import com.example.todo.model.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(Status status);
    List<Task> findByDescriptionContainingIgnoreCase(String description);

    Page<Task> findAll(Pageable pageable);
}