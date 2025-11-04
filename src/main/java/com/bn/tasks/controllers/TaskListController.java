package com.bn.tasks.controllers;

import com.bn.tasks.Services.TaskListService;
import com.bn.tasks.Services.TaskService;
import com.bn.tasks.dto.TaskDto;
import com.bn.tasks.dto.TaskListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/task-lists")
public class TaskListController {
    private final TaskListService taskListService;

    @Autowired
    public TaskListController(TaskListService taskListService) {
        this.taskListService = taskListService;
    }

    @GetMapping
    List<TaskListDto> getAllTaskLists(){
        return this.taskListService.findAllTaskLists();
    }

    @GetMapping("/{task_list_id}")
    TaskListDto getTaskList(@PathVariable("task_list_id") UUID taskListId){
        System.out.println(taskListId);
        return this.taskListService.findTaskList(taskListId);
    }
}
