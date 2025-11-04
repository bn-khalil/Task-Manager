package com.bn.tasks.Services;

import com.bn.tasks.dto.TaskDto;
import com.bn.tasks.dto.TaskListDto;

import java.util.List;
import java.util.UUID;

public interface TaskListService {
    List<TaskListDto> findAllTaskLists();
    TaskListDto findTaskList(UUID taskListId);
    TaskListDto addNewTaskList(TaskListDto taskListDto);
    TaskListDto editTaskList(UUID taskListId, TaskListDto taskListDto);
    void deleteTaskList(UUID taskListId);

}
