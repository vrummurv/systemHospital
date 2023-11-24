package hospital.papers;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecords {
    private Patient patient;
    private int id;
    private static int nextId = 1;
    private List<Appointment> appointments;

    public MedicalRecords(Patient patient) {
        this.patient = patient;
        this.id = nextId;
        nextId++;
        this.appointments = new ArrayList<>();
    }

    public String toString() {
        StringBuilder aux = new StringBuilder();

        for (Appointment appointment : appointments) {
            aux.append(appointment.toString());
        }

        return aux.toString();
    }

    public void createAppointment(Doctor doctor, String reasonOfAppointment,
            String symptoms, String diagnosis, String prescription, String test, String testResults) {
        
        Appointment newAppointment = new Appointment(
                patient,
                doctor,
                reasonOfAppointment,
                symptoms,
                diagnosis,
                prescription,
                test,
                testResults
        );

        addAppointment(newAppointment);
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

    public int getId() {
        return this.id;
    }

    public Patient getPatient() {
        return patient;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public Appointment findAppointmentById(int id) {
        for (Appointment appointment : appointments) {
            if (appointment.getId() == id) {
                return appointment;
            }
        }
        System.out.println("Consulta não encontrada!");
        return null;
    }
}
