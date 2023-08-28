package com.jp.lms;

import com.jp.lms.model.Department;
import com.jp.lms.model.Level;
import com.jp.lms.model.User;
import com.jp.lms.model.Workflow;
import com.jp.lms.repository.DepartmentRepository;
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
	CommandLineRunner commandLineRunner(DepartmentRepository departmentRepository, LevelRepository levelRepository, UserRepository userRepository, WorkflowRepository workflowRepository){
		return args -> {
			Department softwareDepartment = new Department("Software", "SFT", "software@jp.com");
			Department hrDepartment = new Department("Human Resources", "HR", "hr@jp.com");
			departmentRepository.saveAll(List.of(softwareDepartment,hrDepartment));

			Level level1 = new Level("HOD",List.of(softwareDepartment),20L);
			Level level2 = new Level("Manager",List.of(softwareDepartment),10L);
			Level level3 = new Level("HR",List.of(hrDepartment),30L);
			levelRepository.saveAll(List.of(level1,level2,level3));

			Workflow workflow1 = new Workflow("Software Staff", List.of(level1,level2,level3));
			workflowRepository.save(workflow1);

			User user1 = new User("Joy Pedze", "joyp@kenac.co.zw", workflow1);
			userRepository.save(user1);

		};
	}

}
