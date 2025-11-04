package com.bn.tasks.controllers;

import com.bn.tasks.Services.TaskService;
import com.bn.tasks.dto.TaskDto;
import com.bn.tasks.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/task-lists/{task_list_id}/tasks/")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    List<TaskDto> getTasks(@PathVariable UUID taskListId){
        System.out.println(taskListId);
        return this.taskService.listTasksInTaskList(taskListId);
    }

    @GetMapping("{task_id}")
    List<TaskDto> getTask(@RequestParam UUID taskId){
        System.out.println(taskId);
        return this.taskService.listTasksInTaskList(taskId);
    }

    @PostMapping
    TaskDto createNewTask(
            @PathVariable("task_list_id") UUID taskListId,
            @RequestBody TaskDto taskDto ) {
        System.out.println(taskDto.toString());
        return this.taskService.createTask(taskDto, taskListId);
    }
}
