package com.Student_Course_Registration.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Student_Course_Registration.Exception.StudentsNotFoundException;
import com.Student_Course_Registration.Model.Students;
import com.Student_Course_Registration.Repository.StudentsRepository;

@Service
public class StudentsService {
	

	private final StudentsRepository studentsRepository;

    public StudentsService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    // Register Student
    public Students registerStudent(Students student) {
        return studentsRepository.save(student);
    }

    // View All Students
    public List<Students> getAllStudents() {
        return studentsRepository.findAll();
    }

    
    // Update Student Details
    public Students updateStudent(Long studentId, Students updatedStudent) {
        Students existingStudent = getStudentById(studentId);

        existingStudent.setStudentName(updatedStudent.getStudentName());
        existingStudent.setCourseName(updatedStudent.getCourseName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setAge(updatedStudent.getAge());

        return studentsRepository.save(existingStudent);
    }
    
    
    // Find Student By ID
    public Students getStudentById(Long studentId) {
        return studentsRepository.findById(studentId)
                .orElseThrow(() ->
                    new StudentsNotFoundException(
                        "Student not found with ID: " + studentId));
    }

    // Delete Student Registration
    public String deleteStudent(Long studentId) {
        Students student = studentsRepository.findById(studentId)
                .orElseThrow(() ->
                    new StudentsNotFoundException(
                        "Student not found with ID: " + studentId));

        studentsRepository.delete(student);

        return "Student registration deleted successfully";
    }
    
}
