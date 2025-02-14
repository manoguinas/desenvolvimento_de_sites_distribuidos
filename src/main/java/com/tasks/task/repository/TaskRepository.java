package com.tasks.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tasks.task.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}