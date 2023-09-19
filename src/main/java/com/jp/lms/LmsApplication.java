package com.jp.lms;

import com.jp.lms.department.Department;
import com.jp.lms.department.DepartmentRepository;
import com.jp.lms.leave_type.LeaveType;
import com.jp.lms.leave_type.LeaveTypeRepository;
import com.jp.lms.user.Gender;
import com.jp.lms.user.User;
import com.jp.lms.user.UserRepository;
import com.jp.lms.workflow.Workflow;
import com.jp.lms.workflow.WorkflowRepository;
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
										UserRepository userRepository,
										WorkflowRepository workflowRepository){
		return args -> {
			LeaveType annualLeave = new LeaveType("Annual Leave", 15L, 2.5);
			LeaveType sickLeave = new LeaveType("Sick Leave", 180L,0.0);
			leaveTypeRepository.saveAll(List.of(annualLeave,sickLeave));

			Department softwareDepartment = new Department("Software", "SFT", "software@jp.com");
			Department hrDepartment = new Department("Human Resources", "HR", "hr@jp.com");
			departmentRepository.saveAll(List.of(softwareDepartment,hrDepartment));

			Workflow workflow1 = new Workflow("Software Staff");
			workflowRepository.save(workflow1);

			User user1 = new User("Joy", "Pedze", "joyp@kenac.co.zw","Software Developer",Gender.MALE,"Software Staff", List.of(softwareDepartment));
			User user2 = new User("Tania", "Pedze", "taniap@kenac.co.zw","Software Developer",Gender.FEMALE, "Software Staff", List.of(softwareDepartment));
			User user3 = new User("Praise", "Pedze", "praisep@kenac.co.zw","Software Developer",Gender.FEMALE,"Software Staff", List.of(softwareDepartment));
			userRepository.saveAll(List.of(user1,user2,user3));
		};
	}

}
