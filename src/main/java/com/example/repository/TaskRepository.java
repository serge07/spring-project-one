package com.example.repository;

import com.example.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
List<Task> findByTitle(String title);
List<Task> findByTitleContainingIgnoreCase(String title);
List<Task> findBCompleted(boolean completed);

}
