package hospital.papers;

public class Appointment {
    private static int nextId = 1;
    private int id;
    private Patient patient;
    private Doctor doctor;
    private String reasonOfAppointment;
    private String symptoms;
    private String diagnosis;
    private String prescription;
    private String test;
    private String testResults;

    public Appointment(Patient patient, Doctor doctor, String reasonOfAppointment,
            String symptoms, String diagnosis, String prescription, String test, String testResults) {
        this.id = nextId;
        nextId++;
        this.patient = patient;
        this.doctor = doctor;
        this.reasonOfAppointment = reasonOfAppointment;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.test = test;
        this.testResults = testResults;
    }

    public String toString() {
        return "*******************************\n"
                + "* Consulta ID: " + id + "\n"
                + "* Paciente: " + patient.getName() + "\n"
                + "* Médico: " + doctor.getName() + "\n"
                + "* Motivo da consulta: " + reasonOfAppointment + "\n"
                + "* Sintomas: " + symptoms + "\n"
                + "* Diagnóstico: " + diagnosis + "\n"
                + "* Prescrição: " + prescription + "\n"
                + "* Exame: " + test + "\n"
                + "* Resultado do exame: " + testResults + "\n"
                + "*******************************\n";
    }

    public int getId() {
        return id;
    }

    public void setReasonOfAppointment(String reasonOfAppointment) {
        this.reasonOfAppointment = reasonOfAppointment;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public void setTestResults(String testResults) {
        this.testResults = testResults;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getReasonOfAppointment() {
        return reasonOfAppointment;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public String getTest() {
        return test;
    }

    public String getTestResults() {
        return testResults;
    }

}
