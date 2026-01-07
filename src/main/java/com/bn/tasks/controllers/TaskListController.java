package com.bn.tasks.controllers;

import com.bn.tasks.Services.TaskListService;
import com.bn.tasks.dto.TaskListDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users/{user_id}/task-lists")
public class TaskListController {
    private final TaskListService taskListService;

    @Autowired
    public TaskListController(TaskListService taskListService) {
        this.taskListService = taskListService;
    }

    @GetMapping
    ResponseEntity<List<TaskListDto>> getAllTaskLists(@PathVariable("user_id") UUID user_id){
        List<TaskListDto> taskListDto = this.taskListService.findAllTaskListsByUserId(user_id);
        return ResponseEntity.status(HttpStatus.OK).body(taskListDto);
    }

    @PostMapping
    ResponseEntity<TaskListDto> createNewTaskList(
            @Valid
            @PathVariable("user_id") UUID user_id,
            @RequestBody TaskListDto taskListDto){
        System.out.println("this ");
        TaskListDto newtaskListDto = this.taskListService.addNewTaskList(taskListDto, user_id);
        return ResponseEntity.status(HttpStatus.CREATED).body(newtaskListDto);
    }

    @GetMapping("/{task_list_id}")
    ResponseEntity<TaskListDto> getTaskList(@PathVariable("task_list_id") UUID taskListId){
        TaskListDto taskListDto = this.taskListService.findTaskList(taskListId);
        return ResponseEntity.status(HttpStatus.OK).body(taskListDto);
    }

    @PutMapping("/{task_list_id}")
    ResponseEntity<TaskListDto> editTaskList(
            @Valid
            @PathVariable("task_list_id") UUID taskListId,
            @RequestBody TaskListDto taskListDto){
        TaskListDto editedTaskList = this.taskListService.editTaskList(taskListId, taskListDto);
        return ResponseEntity.status(HttpStatus.OK).body(editedTaskList);
    }

    @DeleteMapping("/{task_list_id}")
    ResponseEntity<TaskListDto> deleteTaskList(@PathVariable("task_list_id") UUID taskListId){
        this.taskListService.deleteTaskList(taskListId);
        return ResponseEntity.noContent().build();
    }
}
