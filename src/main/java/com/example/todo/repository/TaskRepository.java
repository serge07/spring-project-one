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
    Page<Task> findByStatus(Status status, Pageable pageable);
    Page<Task> findByDescriptionContainingIgnoreCase(String keyword, Pageable pageable);
    Page<Task> findByDescriptionContainingIgnoreCaseAndStatus(String keyword, Status status, Pageable pageable);

    Page<Task> findAll(Pageable pageable);
}