package com.bn.tasks.Services.Impl;

import com.bn.tasks.Repositories.TaskListRepository;
import com.bn.tasks.Services.TaskListService;
import com.bn.tasks.dto.TaskListDto;
import com.bn.tasks.entities.TaskList;
import com.bn.tasks.exceptions.NotFoundException;
import com.bn.tasks.mappers.TaskListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TestListServiceImpl implements TaskListService {

    final private TaskListRepository taskListRepository;
    final private TaskListMapper taskListMapper;

    @Autowired
    public TestListServiceImpl(
            TaskListRepository taskListRepository,
            TaskListMapper taskListMapper
    ) {
        this.taskListRepository = taskListRepository;
        this.taskListMapper = taskListMapper;
    }

    @Override
    public List<TaskListDto> findAllTaskLists() {
        List<TaskList> taskLists = this.taskListRepository.findAll();
        return taskLists.stream().map(this.taskListMapper::toDto).toList();
    }

    @Override
    public TaskListDto findTaskList(UUID taskListId) {
        TaskList taskList = this.taskListRepository.findTaskListById(taskListId).orElse(null);
        if (taskList == null)
            throw new NotFoundException("Task List Not Found!");
        return this.taskListMapper.toDto(taskList);
    }

    @Override
    public TaskListDto addNewTaskList(TaskListDto taskListDto) {
        if (taskListDto.id() != null)
            throw new IllegalArgumentException("task list already has and id!");
        if (taskListDto.title() == null || taskListDto.title().isEmpty())
            throw new IllegalArgumentException("task list title is required!");

        TaskList taskList = this.taskListMapper.fromDto(taskListDto);
        taskList = this.taskListRepository.save(taskList);
        return this.taskListMapper.toDto(taskList);
    }

    @Override
    public TaskListDto editTaskList(UUID taskListId, TaskListDto taskListDto) {
        TaskList taskList = this.taskListRepository.findById( taskListId ).orElseThrow(
                ()-> new NotFoundException("Task List Not Found with id = " + taskListId)
        );
        taskList.setTile(taskListDto.title());
        taskList.setDescription(taskListDto.description());

        TaskList newTaskList = this.taskListRepository.save(taskList);
        return this.taskListMapper.toDto(newTaskList);
    }

    @Override
    public void deleteTaskList(UUID taskListId) {
        if(!this.taskListRepository.existsById(taskListId))
            throw new NotFoundException("task list you want to delete not found!");
        this.taskListRepository.deleteById(taskListId);
    }
}
