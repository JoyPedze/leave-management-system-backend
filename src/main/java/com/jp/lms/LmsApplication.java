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
			LeaveType annualLeave = new LeaveType("Annual Leave", 15L);
			LeaveType sickLeave = new LeaveType("Sick Leave", 180L);
			leaveTypeRepository.saveAll(List.of(annualLeave,sickLeave));

			Department softwareDepartment = new Department("Software", "SFT", "software@jp.com");
			Department hrDepartment = new Department("Human Resources", "HR", "hr@jp.com");
			departmentRepository.saveAll(List.of(softwareDepartment,hrDepartment));

			Level level1 = new Level("HOD",List.of(softwareDepartment),20L);
			Level level2 = new Level("Manager",List.of(softwareDepartment),10L);
			Level level3 = new Level("HR",List.of(hrDepartment),30L);
			levelRepository.saveAll(List.of(level1,level2,level3));

			Workflow workflow1 = new Workflow("Software Staff", List.of(level1,level2,level3));
			workflowRepository.save(workflow1);

			User user1 = new User("Joy", "Pedze", "joyp@kenac.co.zw","Software Developer",level1, List.of(softwareDepartment),Gender.MALE, workflow1);
			User user2 = new User("Tania", "Pedze", "taniap@kenac.co.zw","Software Developer", level2, List.of(softwareDepartment),Gender.FEMALE, workflow1);
			User user3 = new User("Praise", "Pedze", "praisep@kenac.co.zw","Software Developer", level3, List.of(hrDepartment),Gender.FEMALE, workflow1);
			userRepository.saveAll(List.of(user1));
		};
	}

}
