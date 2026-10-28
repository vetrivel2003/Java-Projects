package com.example.HospitalAppointmentBooking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HospitalAppointmentBooking.Model.Appointment;
@Repository

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
					
}
