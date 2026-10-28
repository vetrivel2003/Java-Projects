package com.Student_Course_Registration.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Student_Course_Registration.Model.Students;

public interface StudentsRepository extends JpaRepository<Students, Long> {

}
