package com.bn.tasks.Services;

import com.bn.tasks.dto.TaskDto;
import com.bn.tasks.dto.TaskListDto;

import java.util.List;
import java.util.UUID;

public interface TaskListService {
    List<TaskListDto> findAllTaskListsByUserId(UUID user_id);
    TaskListDto findTaskList(UUID taskListId);
    TaskListDto addNewTaskList(TaskListDto taskListDto, UUID user_id);
    TaskListDto editTaskList(UUID taskListId, TaskListDto taskListDto);
    void deleteTaskList(UUID taskListId);

}
