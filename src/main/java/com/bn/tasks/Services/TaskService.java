package com.bn.tasks.Services;

import com.bn.tasks.dto.TaskDto;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    TaskDto getTask(UUID id);
    List<TaskDto> getTasksWithTaskListId(UUID taskListId);
    TaskDto createTask(TaskDto taskDto, UUID taskListId);
}
