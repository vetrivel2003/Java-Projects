package com.example.HospitalAppointmentBooking.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.HospitalAppointmentBooking.Model.Appointment;
import com.example.HospitalAppointmentBooking.Repository.AppointmentRepository;


@Service
public class AppointmentService {

    private final AppointmentRepository repository;

    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }

    public Appointment bookAppointment(Appointment appointment) {
        return repository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return repository.findAll();
    }

    public Appointment getAppointmentById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Appointment updateAppointment(int id, Appointment appointment) {
        return repository.findById(id).map(existing -> {
            existing.setPatientName(appointment.getPatientName());
            existing.setDoctorName(appointment.getDoctorName());
            existing.setDisease(appointment.getDisease());
            existing.setAppointmentDate(appointment.getAppointmentDate());
            return repository.save(existing);
        }).orElse(null);
    }

    public boolean deleteAppointment(int id) {
        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);
        return true;
    }
}