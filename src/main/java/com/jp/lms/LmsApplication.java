package com.jp.lms;

import com.jp.lms.model.Level;
import com.jp.lms.model.User;
import com.jp.lms.model.Workflow;
import com.jp.lms.repository.LevelRepository;
import com.jp.lms.repository.UserRepository;
import com.jp.lms.repository.WorkflowRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class LmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmsApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(LevelRepository levelRepository, UserRepository userRepository, WorkflowRepository workflowRepository){
		return args -> {
			Level level1 = new Level("HOD","Software",20L);
			Level level2 = new Level("Manager","Software",10L);
			Level level3 = new Level("HR","Human Resources",30L);
			levelRepository.saveAll(List.of(level1,level2,level3));

			Workflow workflow1 = new Workflow("Software Staff", List.of(level1,level2,level3));
			workflowRepository.save(workflow1);

			User user1 = new User("Joy Pedze", "joyp@kenac.co.zw", workflow1);
			userRepository.save(user1);

		};
	}

}
