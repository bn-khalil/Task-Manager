package com.bn.tasks.mappers.Impl;

import com.bn.tasks.dto.TaskListDto;
import com.bn.tasks.entities.TaskList;
import com.bn.tasks.mappers.TaskListMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TaskListMapperImpl implements TaskListMapper {

    final private TaskMapperImpl taskMapper;

    public TaskListMapperImpl(TaskMapperImpl taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskList fromDto(TaskListDto taskListDto) {
        return new TaskList(
                taskListDto.id(),
                taskListDto.title(),
                taskListDto.description(),
                null,
                Optional.ofNullable(taskListDto.tasksDto())
                        .map(taskDtos -> taskDtos
                                .stream()
                                .map(this.taskMapper::fromDto)
                                .toList())
                        .orElse(null),
                null,
                null
        );
    }

    @Override
    public TaskListDto toDto(TaskList taskList) {
        return new TaskListDto(
                taskList.getId(),
                taskList.getTile(),
                taskList.getDescription(),
                Optional.ofNullable(taskList.getTasks())
                        .map(tasks -> tasks
                                .stream()
                                .map(taskMapper::toDto)
                                .toList())
                        .orElse(null)
        );
    }
}
