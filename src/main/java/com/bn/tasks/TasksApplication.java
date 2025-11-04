package com.bn.tasks;

import com.bn.tasks.Services.TaskListService;
import com.bn.tasks.dto.TaskListDto;
import com.bn.tasks.entities.TaskList;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class TasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasksApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRuner(TaskListService taskListService){
//		return args -> {
////			TaskListDto taskListDto = TaskListDto.builder()
////					.title("studding at school")
////					.description("to complete this mission there are a few tasks to complete.")
////					.build();
////			taskListService.addNewTaskList(taskListDto);
//			TaskListDto taskListDto = taskListService.findTaskList(UUID.fromString("789c9fae-0671-4227-9e6f-c3585173b623"));
//			System.out.println(taskListDto.title());
//		};
//	}
}
