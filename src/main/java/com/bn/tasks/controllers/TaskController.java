package com.bn.tasks.controllers;

import com.bn.tasks.Services.TaskService;
import com.bn.tasks.dto.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/task-lists/{task_list_id}/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    List<TaskDto> getTasks(@PathVariable("task_list_id") UUID taskListId){
        System.out.println(taskListId);
        return this.taskService.getTasksWithTaskListId(taskListId);
    }

    @PostMapping
    TaskDto createNewTask(
            @PathVariable("task_list_id") UUID taskListId,
            @RequestBody TaskDto taskDto ) {
        return this.taskService.createTask(taskDto, taskListId);
    }

    @GetMapping("/{task_id}")
    TaskDto getTask(@PathVariable("task_id") UUID taskId){
        return this.taskService.getTask(taskId);
    }
}
