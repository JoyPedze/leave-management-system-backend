package com.jp.lms;

import com.jp.lms.model.*;
import com.jp.lms.model.enums.Gender;
import com.jp.lms.repository.*;
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
	CommandLineRunner commandLineRunner(LeaveTypeRepository leaveTypeRepository,
										DepartmentRepository departmentRepository,
										LevelRepository levelRepository,
										UserRepository userRepository,
										WorkflowRepository workflowRepository){
		return args -> {
			LeaveType annualLeave = new LeaveType("Annual Leave", 15L, 2.5);
			LeaveType sickLeave = new LeaveType("Sick Leave", 180L,0.0);
			leaveTypeRepository.saveAll(List.of(annualLeave,sickLeave));

			Department softwareDepartment = new Department("Software", "SFT", "software@jp.com");
			Department hrDepartment = new Department("Human Resources", "HR", "hr@jp.com");
			departmentRepository.saveAll(List.of(softwareDepartment,hrDepartment));

			Level level1 = new Level("HOD",20L,List.of(softwareDepartment));
			Level level2 = new Level("Manager",10L,List.of(softwareDepartment));
			Level level3 = new Level("HR",30L,List.of(hrDepartment));
			levelRepository.saveAll(List.of(level1,level2,level3));

			Workflow workflow1 = new Workflow("Software Staff", List.of(level1,level2,level3));
			workflowRepository.save(workflow1);

			User user1 = new User("Joy", "Pedze", "joyp@kenac.co.zw","Software Developer",Gender.MALE,level1, List.of(softwareDepartment),workflow1);
			User user2 = new User("Tania", "Pedze", "taniap@kenac.co.zw","Software Developer",Gender.FEMALE, level2, List.of(softwareDepartment), workflow1);
			User user3 = new User("Praise", "Pedze", "praisep@kenac.co.zw","Software Developer",Gender.FEMALE, level3, List.of(hrDepartment), workflow1);
			userRepository.saveAll(List.of(user1,user2,user3));
		};
	}

}
