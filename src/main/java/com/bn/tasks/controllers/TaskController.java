package com.bn.tasks.controllers;

import com.bn.tasks.Services.TaskService;
import com.bn.tasks.dto.TaskDto;
import com.bn.tasks.dto.TaskListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<List<TaskDto>> getTasks(@PathVariable("task_list_id") UUID taskListId){
        List<TaskDto> tasksDto = this.taskService.getTasksWithTaskListId(taskListId);
        return ResponseEntity.status(HttpStatus.OK).body(tasksDto);
    }

    @PostMapping
    ResponseEntity<TaskDto> createNewTask(
            @PathVariable("task_list_id") UUID taskListId,
            @RequestBody TaskDto taskDto ) {
        TaskDto newTaskDto = this.taskService.createTask(taskDto, taskListId);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTaskDto);
    }

    @GetMapping("/{task_id}")
    ResponseEntity<TaskDto> getTask(@PathVariable("task_id") UUID taskId){
        TaskDto taskDto = this.taskService.getTask(taskId);
        return ResponseEntity.status(HttpStatus.OK).body(taskDto);
    }

    @PutMapping("/{task_id}")
    ResponseEntity<TaskDto> editTaskList(
            @PathVariable("task_id") UUID taskId,
            @RequestBody TaskDto taskDto){
        TaskDto editedTask = this.taskService.editTask(taskId, taskDto);
        return ResponseEntity.status(HttpStatus.OK).body(editedTask);
    }

    @DeleteMapping("/{task_id}")
    ResponseEntity<TaskListDto> deleteTaskList(@PathVariable("task_id") UUID taskId){
        this.taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }
}
