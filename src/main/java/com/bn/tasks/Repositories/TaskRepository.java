package com.bn.tasks.Repositories;

import com.bn.tasks.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
    @Query("select t from Task t where t.taskList.id = :taskListId")
    List<Task> findByTaskListId(@Param("taskListId") UUID taskListId);
}

