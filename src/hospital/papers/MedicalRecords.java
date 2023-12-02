package hospital.papers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecords implements Serializable{
    private Patient patient;
    private int id;
    private List<Appointment> appointments;

    public MedicalRecords(Patient patient, int id) {
        this.patient = patient;
        this.id = id;
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
            String symptoms, String diagnosis, String prescription, String test, String testResults, int id) {
        
        Appointment newAppointment = new Appointment(
                patient,
                doctor,
                reasonOfAppointment,
                symptoms,
                diagnosis,
                prescription,
                test,
                testResults, 
                id
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

    public Appointment findAppointmentById(int id) throws Exception{
        for (Appointment appointment : appointments) {
            if (appointment.getId() == id) {
                return appointment;
            }
        }
        throw new Exception("Consulta não encontrada!");
    }
}
