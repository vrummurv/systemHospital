package hospital.papers;

import java.util.Map;
import java.util.Scanner;

import hospital.SystemHospital;
import hospital.staff.*;

public class Nurse extends Employee {
    public Nurse(String name, Specialty specialty, String position, int password) {
        super(name, specialty, position, password);
    }

    public void updateAppointment(SystemHospital system, Map<Integer, MedicalRecords> medicalRecordsMap) {
        Scanner input = new Scanner(System.in);

        System.out.println("\nId do paciente: ");
        int idPatient = input.nextInt();
        input.nextLine(); // Consumindo o \n
        Patient patient = system.findPatientById(idPatient);

        MedicalRecords medicalRecords = medicalRecordsMap.get(idPatient);

        if (medicalRecords == null) {
            System.out.println("Prontuário não encontrado!");
            return;
        }

        medicalRecords.toString();
        System.out.println("\nId da consulta: ");
        int idAppointment = input.nextInt();
        input.nextLine(); // Consumindo o \n
        Appointment appointment = medicalRecords.findAppointmentById(idAppointment);

        System.out.println("\nMotivo da consulta: ");
        String reasonOfAppointment = input.nextLine();

        System.out.println("\nSintomas: ");
        String symptoms = input.nextLine();

        System.out.println("\nDiagnóstico: ");
        String diagnosis = input.nextLine();

        System.out.println("\nPrescrição: ");
        String prescription = input.nextLine();

        System.out.println("\nExame: ");
        String test = input.nextLine();

        System.out.println("\nResultado do exame: ");
        String testResults = input.nextLine();

        appointment.setReasonOfAppointment(reasonOfAppointment);
        appointment.setSymptoms(symptoms);
        appointment.setDiagnosis(diagnosis);
        appointment.setPrescription(prescription);
        appointment.setTest(test);
        appointment.setTestResults(testResults);

        System.out.println("====== Consulta atualizada com sucesso! ======");
    }
}
