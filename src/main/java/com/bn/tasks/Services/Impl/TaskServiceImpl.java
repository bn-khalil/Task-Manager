package com.bn.tasks.Services.Impl;

import com.bn.tasks.Repositories.TaskListRepository;
import com.bn.tasks.Repositories.TaskRepository;
import com.bn.tasks.Services.TaskListService;
import com.bn.tasks.Services.TaskService;
import com.bn.tasks.dto.TaskDto;
import com.bn.tasks.dto.TaskListDto;
import com.bn.tasks.entities.Task;
import com.bn.tasks.entities.TaskList;
import com.bn.tasks.exceptions.TaskException;
import com.bn.tasks.exceptions.TaskListException;
import com.bn.tasks.mappers.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    final private TaskRepository taskRepository;
    final private TaskListRepository taskListRepository;
    final private TaskMapper taskMapper;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository,
                           TaskMapper taskMapper,
                           TaskListRepository taskListRepository) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.taskListRepository = taskListRepository;
    }

    @Override
    public TaskDto getTask(UUID id) {
        Task task = this.taskRepository.findById(id).orElseThrow(
                ()-> new TaskException("Task Not Found!")
        );
        return this.taskMapper.toDto(task);
    }

    @Override
    public List<TaskDto> getTasksWithTaskListId(UUID taskListId) {
        List<Task> tasks = this.taskRepository.findByTaskListId(taskListId);
        return tasks.stream().map(this.taskMapper::toDto).toList();
    }

    @Override
    public TaskDto createTask(TaskDto taskDto, UUID taskListId) {
        TaskList taskList = this.taskListRepository.findById(taskListId).orElseThrow(
                ()-> new TaskListException("Task List Not Found to Add New Task!")
        );
        Task task = this.taskMapper.fromDto(taskDto);
        task.setTaskList(taskList);
        task = this.taskRepository.save(task);
        return this.taskMapper.toDto(task);
    }
}
