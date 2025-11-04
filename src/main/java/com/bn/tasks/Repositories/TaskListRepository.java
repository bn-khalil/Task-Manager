package com.bn.tasks.Repositories;

import com.bn.tasks.entities.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskListRepository extends JpaRepository<TaskList, UUID> {
    @Query("SELECT DISTINCT tl FROM TaskList tl LEFT JOIN FETCH tl.tasks WHERE tl.id = :id")
    Optional<TaskList> findTaskListById(UUID id);
}
