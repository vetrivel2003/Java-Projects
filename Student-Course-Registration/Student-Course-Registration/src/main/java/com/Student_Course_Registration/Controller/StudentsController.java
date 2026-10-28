package com.Student_Course_Registration.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Student_Course_Registration.Model.Students;
import com.Student_Course_Registration.Service.StudentsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/students")
public class StudentsController {
	@Autowired
	private StudentsService studentsService;

	// Register Student
	@PostMapping("/register")
	public ResponseEntity<Students> registerStudent(@Valid @RequestBody Students student) {

		Students savedStudent = studentsService.registerStudent(student);

		return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
	}

	// View All Students
	@GetMapping
	public ResponseEntity<List<Students>> getAllStudents() {
		return ResponseEntity.ok(studentsService.getAllStudents());
	}

	// Find Student By ID
	@GetMapping("/{studentId}")
	public ResponseEntity<Students> getStudentById(@PathVariable Long studentId) {

		Students student = studentsService.getStudentById(studentId);

		return ResponseEntity.ok(student);
	}

	@PutMapping("/{studentId}")
	public ResponseEntity<Students> updateStudent(@PathVariable Long studentId, @Valid @RequestBody Students student) {

		return ResponseEntity.ok(studentsService.updateStudent(studentId, student));
	}

	// Delete Student Registration
	@DeleteMapping("/{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long studentId) {

		String message = studentsService.deleteStudent(studentId);

		return ResponseEntity.ok(message);
	}

}
